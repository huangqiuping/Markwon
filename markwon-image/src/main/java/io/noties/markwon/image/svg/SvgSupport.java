package io.noties.markwon.image.svg;

import android.util.Log;

import androidx.annotation.NonNull;

/**
 * @since 4.0.0
 */
public abstract class SvgSupport {

    private static final boolean HAS_SVG;

    static {
        boolean result;
        try {
            com.caverock.androidsvg.SVG.class.getName();
            result = true;
        } catch (Throwable t) {
            // @since 4.1.1-SNAPSHOT instead of printing full stacktrace of the exception,
            // just print a warning to the console
            Log.w("MarkwonImagesPlugin", missingMessage());
            result = false;
        }
        HAS_SVG = result;
    }

    public static boolean hasSvgSupport() {
        return HAS_SVG;
    }

    /**
     * @since 4.1.1-SNAPSHOT
     */
    @NonNull
    static String missingMessage() {
        return "`com.caverock:androidsvg:*` dependency is missing, " +
                "please add to your project explicitly if you wish to use SVG media-decoder";
    }

    private SvgSupport() {
    }
}
