/*
 * Copyright (C) 2016 Gson Type Adapter Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit tests for {@link LocalDateTypeAdapter}.
 *
 * @author Christophe Bornet
 */
public class LocalDateTypeAdapterTest {
  private static final Gson gson = new GsonBuilder()
    .registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
    .create();

  @Test
  public void testSerialization() {
    LocalDate date = new LocalDate(2014,3,30);
    String json = gson.toJson(date);
    assertEquals("\"2014-03-30\"", json);
  }

  @Test
  public void testDeserialization() {
    LocalDate date = gson.fromJson("'2014-03-30'", LocalDate.class);
    assertEquals(2014, date.getYear());
    assertEquals(3, date.getMonthOfYear());
    assertEquals(30, date.getDayOfMonth());
  }
}
