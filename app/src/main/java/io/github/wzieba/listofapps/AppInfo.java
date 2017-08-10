package io.github.wzieba.listofapps;


import android.graphics.drawable.Drawable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class AppInfo {
    private final int uid;
    private final String name;
    private final Drawable icon;
}
