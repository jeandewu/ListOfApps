package io.github.wzieba.listofapps;


import android.graphics.drawable.Drawable;

import lombok.Data;


@Data
class AppInfo {
    private final int uid;
    private final String name;
    private final Drawable icon;
}
