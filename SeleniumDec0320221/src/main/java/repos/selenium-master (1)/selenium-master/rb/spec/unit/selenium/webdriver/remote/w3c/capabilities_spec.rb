# Licensed to the Software Freedom Conservancy (SFC) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The SFC licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#   http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.

require File.expand_path('../../../spec_helper', __FILE__)

module Selenium
  module WebDriver
    module Remote
      module W3C
        describe Capabilities do
          it 'lower cases proxy' do
            proxy = Selenium::WebDriver::Proxy.new(http: 'proxy_url')
            caps = described_class.new(proxy: proxy)
            expect(caps.as_json['proxy']['proxyType']).to eq('manual')
          end

          it 'converts noProxy from string to array' do
            proxy = Selenium::WebDriver::Proxy.new(no_proxy: 'proxy_url, localhost')
            caps = described_class.new(proxy: proxy)
            expect(caps.as_json['proxy']['noProxy']).to eq(%w[proxy_url localhost])
          end

          it 'does not convert noProxy if it is already array' do
            proxy = Selenium::WebDriver::Proxy.new(no_proxy: ['proxy_url'])
            caps = described_class.new(proxy: proxy)
            expect(caps.as_json['proxy']['noProxy']).to eq(['proxy_url'])
          end
        end
      end # W3C
    end # Remote
  end # WebDriver
end # Selenium
