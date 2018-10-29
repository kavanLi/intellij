/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.file.upload;

/**
 * File upload helper to write file to target repository.
 */
public interface FileUploadService {

    String getUploadFileExtension(String contentType);

    boolean allowUploadImageContentType(String contentType);
}
