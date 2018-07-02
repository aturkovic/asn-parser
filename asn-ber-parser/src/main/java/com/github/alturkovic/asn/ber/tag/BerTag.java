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

package com.github.alturkovic.asn.ber.tag;

import com.github.alturkovic.asn.Type;
import com.github.alturkovic.asn.tag.Tag;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(of = {"value", "type"})
public class BerTag implements Tag {
  private final int value;
  private final Type type;
  private final boolean constructed;

  public BerTag(final int value, final Type type, final boolean constructed) {
    this.value = value;
    this.type = type;
    this.constructed = constructed;
  }

  @Override
  // order by type, then by value
  public int compareTo(final Tag o) {
    if (!(o instanceof BerTag)) {
      // should not happen, if it does, just mix the two, doesn't matter much
      return 0;
    }

    final int typeComparison = type.compareTo(((BerTag) o).type);

    if (typeComparison != 0) {
      return typeComparison;
    }

    return Integer.compare(value, ((BerTag) o).value);
  }
}