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
import java.time.LocalDateTime;

/**
 * Type adapter for jsr310 {@link LocalDateTime} class.
 *
 * @author Christophe Bornet
 */
public class LocalDateTimeTypeAdapter extends DateTimeTypeAdapter<LocalDateTime> {

  public LocalDateTimeTypeAdapter() {
    super(LocalDateTime::parse);
  }
}