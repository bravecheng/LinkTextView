package mobi.chy.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Custom Link TextView
 *
 * Created by @author chengyong on 2018/2/8.
 */

@SuppressLint("AppCompatCustomView")
public class LinkTextView extends TextView {

    private String mLink;
    private int mLinkColor;
    private OnLinkClickListener mListener;

    public LinkTextView(Context context) {
        this(context,null);
    }

    public LinkTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinkTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.LinkTextView, defStyleAttr, 0);
        mLink = typedArray.getString(R.styleable.LinkTextView_link);
        mLinkColor = typedArray.getResourceId(R.styleable.LinkTextView_linkColor,-1);
        autoLink();
    }

    private void autoLink(){
        if (!TextUtils.isEmpty(getText()) && !TextUtils.isEmpty(mLink)) {
            int[]data = matchStartAndEnd(getText(), mLink);
            SpannableString ss = new SpannableString(getText());
            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View textView) {
                    if (mListener != null) {
                        mListener.onLinkClick();
                    }
                }
                @Override
                public void updateDrawState(TextPaint ds) {
                    super.updateDrawState(ds);
                    ds.setUnderlineText(true);
                    ds.setColor(getResources().getColor(mLinkColor));
                }
            };
            ss.setSpan(clickableSpan, data[0], data[1], Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            setText(ss);
            setMovementMethod(LinkMovementMethod.getInstance());
            setHighlightColor(Color.TRANSPARENT);
        }
    }

    public interface OnLinkClickListener {
        void onLinkClick();
    }

    public void setLinkText(String link){
        this.mLink = link;
        autoLink();
    }

    public void setOnLinkClickListener(OnLinkClickListener listener){
        this.mListener = listener;
    }

    private int[] matchStartAndEnd(CharSequence text, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int[] data = new int[2];
        while (matcher.find()) {
            data[0] = matcher.start();
            data[1] = matcher.end();
        }
        return data;
    }

}
