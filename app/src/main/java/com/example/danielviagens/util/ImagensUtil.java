package com.example.danielviagens.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

public class ImagensUtil {

    public static Drawable devolveDrawable(Context context, String drawableEmTexto) {
        Resources resources = context.getResources();
        int idDoMipMap = resources.getIdentifier(drawableEmTexto,
                "mipmap", context.getPackageName());
        return resources.getDrawable(idDoMipMap);
    }
}
