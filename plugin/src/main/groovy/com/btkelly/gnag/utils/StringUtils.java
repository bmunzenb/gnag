/**
 * Copyright 2016 Bryan Kelly
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.btkelly.gnag.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class StringUtils {

    /**
     * @return null if string is null; a new String generated by trimming all whitespace and newlines from string
     * otherwise.
     */
    @Nullable
    public static String sanitizePreservingNulls(@Nullable final String string) {
        if (string == null) {
            return "";
        }

        return string
                .trim()
                .replaceAll("^\\r|^\\n|\\r$\\n$", "");
    }


    /**
     * @return an empty String if string is null; a new String generated by trimming all whitespace and newlines from
     * string otherwise.
     */
    @NotNull
    public static String sanitizeToNonNull(@Nullable final String string) {
        final String nullableSanitizedString = sanitizePreservingNulls(string);

        return nullableSanitizedString != null ? nullableSanitizedString : "";
    }
    
    @NotNull
    public static String capitalizeFirstChar(@NotNull final String string) {
        return string.substring(0, 1).toUpperCase() + string.substring(1);
    }

    public static boolean isBlank(@Nullable final String string) {
        return string == null || string.trim().isEmpty();
    }

    public static boolean isNotBlank(@Nullable final String string) {
        return !isBlank(string);
    }

    private StringUtils() {
        // This constructor intentionally left blank.
    }
    
}
