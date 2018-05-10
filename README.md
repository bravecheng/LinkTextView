# LinkTextView

[ ![Download](https://api.bintray.com/packages/bravecheng/maven/LinkTextView/images/download.svg) ](https://bintray.com/bravecheng/maven/LinkTextView/_latestVersion)

## 效果

<img src="https://raw.githubusercontent.com/bravecheng/LinkTextView/master/Screenshot_LinkTextView.png" width="300">

## 用法

目前该控件已经上传到jcenter仓库，直接按照正常的依赖即可。

> compile 'mobi.chy:LinkTextView:0.1.0'

加入依赖以后，在需要用到的地方把TextView替换成LinkTextView

    <mobi.chy.widget.LinkTextView
        android:id="@+id/ltv_demo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_margin="10dp"
        android:text="Towering genius disdains a beaten path."
        android:textSize="16sp"
        app:link="genius"
        app:linkColor="@color/colorAccent"/>


**app:link**  
需要匹配并显示超链接的文字  
**app:linkColor**  
定制超链接文字颜色  
**app:showUnderline**  
是否需要显示下划线，默认**true**显示  

定义好以后，在代码中加入监听

    LinkTextView ltvDemo = findViewById(R.id.ltv_demo);
    ltvDemo.setOnLinkClickListener(new LinkTextView.OnLinkClickListener() {
        @Override
        public void onLinkClick() {
            Toast.makeText(DemoActivity.this,"link clicked!",Toast.LENGTH_LONG).show();
        }
    });


