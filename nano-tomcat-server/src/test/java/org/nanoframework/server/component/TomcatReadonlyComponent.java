/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nanoframework.server.component;

import org.nanoframework.core.component.stereotype.Component;
import org.nanoframework.core.component.stereotype.bind.PathVariable;
import org.nanoframework.core.component.stereotype.bind.RequestMapping;
import org.nanoframework.core.component.stereotype.bind.RequestMethod;
import org.nanoframework.core.component.stereotype.bind.RequestParam;
import org.nanoframework.server.component.impl.TomcatReadonlyComponentImpl;
import org.nanoframework.web.server.http.status.ResultMap;

import com.google.inject.ImplementedBy;

/**
 *
 * @author yanghe
 * @since 1.4.3
 */
@Component
@ImplementedBy(TomcatReadonlyComponentImpl.class)
public interface TomcatReadonlyComponent {

    @RequestMapping(value = "/put/{key}", method = RequestMethod.PUT)
    ResultMap put(@PathVariable("key") String key, @RequestParam("spec") String spec, @RequestParam("value") String value);
    
    @RequestMapping(value = "/put/arr/{key}", method = RequestMethod.PUT)
    ResultMap putArray(@PathVariable("key") String key, @RequestParam("values[]") String[] values);
    
    @RequestMapping(value = "/put/json/{key}", method = RequestMethod.PUT)
    ResultMap putJson(@PathVariable("key") String key);
    
    @RequestMapping(value = "/del/{key}", method = RequestMethod.DELETE)
    ResultMap del(@PathVariable("key") String key, @RequestParam("spec") String spec, @RequestParam("value") String value);
    
    @RequestMapping(value = "/post/{key}", method = RequestMethod.POST)
    ResultMap post(@PathVariable("key") String key, @RequestParam("spec") String spec, @RequestParam("value") String value);
}
