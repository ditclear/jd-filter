package com.ditclear.app;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.ditclear.app.ItemType.content;
import static com.ditclear.app.ItemType.content1;
import static com.ditclear.app.ItemType.content2;
import static com.ditclear.app.ItemType.content3;
import static com.ditclear.app.ItemType.footer;
import static com.ditclear.app.ItemType.header;

/**
 * 页面描述：
 * <p>
 * Created by ditclear on 2017/2/19.
 */
@IntDef({header,content,content1,content2,content3,footer})
@Retention(RetentionPolicy.CLASS)
public @interface ItemType {
    int header= 1234;
    int content=2345;
    int content1=23451;
    int content2=23452;
    int content3=23453;
    int footer=3456;
}
