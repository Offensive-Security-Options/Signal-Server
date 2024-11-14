/*
 * Copyright 2024 Signal Messenger, LLC
 * SPDX-License-Identifier: AGPL-3.0-only
 */

package org.whispersystems.textsecuregcm.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.whispersystems.textsecuregcm.storage.Device;

public record TransferArchiveUploadedRequest(@Min(1)
                                             @Max(Device.MAXIMUM_DEVICE_ID)
                                             @Schema(description = "The ID of the device for which the transfer archive has been prepared")
                                             byte destinationDeviceId,

                                             @Positive
                                             @Schema(description = "The timestamp, in milliseconds since the epoch, at which the destination device was created")
                                             long destinationDeviceCreated,

                                             @Schema(description = "The location of the transfer archive")
                                             @Valid
                                             RemoteAttachment transferArchive) {
}