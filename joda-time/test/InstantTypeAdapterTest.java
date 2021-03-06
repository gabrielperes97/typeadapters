/*
 * Copyright (C) 2014 Gson Type Adapter Authors.
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
import static org.junit.Assert.assertEquals;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Instant;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Unit tests for {@link InstantTypeAdapter}.
 *
 * @author Inderjeet Singh
 */
public class InstantTypeAdapterTest {
  private static final Gson gson = new GsonBuilder()
    .registerTypeAdapter(Instant.class, new InstantTypeAdapter())
    .create();

  @Test
  public void testSerialization() {
    Instant time = new Instant(1396141013512L);
    String json = gson.toJson(time);
    assertEquals("\"2014-03-30T00:56:53.512Z\"", json);
  }

  @Test
  public void testDeserialization() {
    Instant instant = gson.fromJson("\"2014-03-30T00:56:53.512Z\"", Instant.class);
    assertEquals(DateTimeZone.UTC, instant.getZone());
    assertEquals(1396141013512L, instant.getMillis());
  }
}
