/*
 * MIT License
 *
 * Copyright (c) 2018 Alen Turkovic
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.alturkovic.asn.field;

import com.github.alturkovic.asn.converter.AsnConverter;
import com.github.alturkovic.asn.tag.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.lang.reflect.Field;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CollectionTaggedField extends TaggedField {
    private final boolean structured;
    private final Class<?> type;
    private final Tag elementTag;
    private final Class<? extends AsnConverter<?, ?>> converter;

    public CollectionTaggedField(final int fieldPosition, final Tag tag, final Field field, final boolean structured, final Class<?> type, final Tag elementTag, final Class<? extends AsnConverter<?, ?>> converter) {
        super(fieldPosition, tag, field);
        this.structured = structured;
        this.type = type;
        this.elementTag = elementTag;
        this.converter = converter;
    }

    @Override
    public boolean isCollection() {
        return true;
    }
}