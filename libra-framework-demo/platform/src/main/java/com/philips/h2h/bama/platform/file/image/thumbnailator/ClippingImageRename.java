/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.file.image.thumbnailator;

import com.philips.h2h.bama.platform.file.model.ImageDimension;

import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.name.Rename;

/**
 * Rename clipped images after clipping successfully: /xxxxx_120x120q50.jpeg.
 */
public class ClippingImageRename extends Rename {

    /* fields ------------------------------------------------------ */

    private final static String DEFAULT_SUFFIX = "-no-dimension";
    private final static String DIMENSION_SEPARATOR = "x";
    // image clipping params from
    private ImageDimension imageDimension;

    /* constructors ------------------------------------------------------ */

    public ClippingImageRename() {
    }

    public ClippingImageRename(ImageDimension imageDimension) {
        this.imageDimension = imageDimension;
    }

    /* public methods ------------------------------------------------------ */

    @Override
    public String apply(String name, ThumbnailParameter param) {
        // name is absolute file name
        return appendSuffix(name, getSuffix());
    }

    /**
     * Get suffix of clipping image to append after original file name.
     *
     * @return the suffix for file name with clipped dimension params
     */
    public String getSuffix() {
        StringBuffer suffix = new StringBuffer();
        if (this.imageDimension == null) {
            suffix.append(DEFAULT_SUFFIX);
        } else {
            suffix.append(this.imageDimension.getWidth()).append(DIMENSION_SEPARATOR)
                    .append(this.imageDimension.getHeight()).append(this.imageDimension.getQualityType());
        }

        return suffix.toString();
    }
}
