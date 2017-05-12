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
package org.nanoframework.extension.shiro.client.matchers;

import java.util.regex.Pattern;

/**
 *
 * @author yanghe
 * @since 1.3.7
 */
public final class RegexUrlPatternMatcherStrategy implements UrlPatternMatcherStrategy {

    private Pattern pattern;

    public RegexUrlPatternMatcherStrategy() {}

    public RegexUrlPatternMatcherStrategy(final String pattern) {
        this.setPattern(pattern);
    }
    
    public boolean matches(final String url) {
        return this.pattern.matcher(url).find();
    }

    public void setPattern(final String pattern) {
        this.pattern = Pattern.compile(pattern);
    }
}
