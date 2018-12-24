/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.core.log.logger;

import lombok.extern.slf4j.Slf4j;
import org.springblade.core.log.publisher.BladeLogPublisher;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

/**
 * 日志工具类
 */
@Slf4j
public class BladeLogger implements InitializingBean {

    @Value("${spring.application.name}")
    private String serviceId;

    public void info(String id, String data) {
        BladeLogPublisher.publishEvent("info", id, data);
    }

    public void debug(String id, String data) {
        BladeLogPublisher.publishEvent("debug", id, data);
    }

    public void warn(String id, String data) {
        BladeLogPublisher.publishEvent("warn", id, data);
    }

    public void error(String id, String data) {
        BladeLogPublisher.publishEvent("error", id, data);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info(serviceId + ": BladeLogger init success!");
    }

}