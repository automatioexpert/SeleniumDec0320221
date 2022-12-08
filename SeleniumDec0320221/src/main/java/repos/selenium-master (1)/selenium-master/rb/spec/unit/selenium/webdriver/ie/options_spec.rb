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

require File.expand_path('../../spec_helper', __FILE__)

module Selenium
  module WebDriver
    module IE
      describe Options do

        describe '#initialize' do
          it 'sets passed args' do
            opt = Options.new(args: %w[foo bar])
            expect(opt.args.to_a).to eq(%w[foo bar])
          end

          it 'sets passed browser_attach_timeout' do
            opt = Options.new(browser_attach_timeout: 30000)
            expect(opt.browser_attach_timeout).to eq(30000)
          end

          it 'sets passed element_scroll_behavior' do
            opt = Options.new(element_scroll_behavior: Options::SCROLL_BOTTOM)
            expect(opt.element_scroll_behavior).to eq(1)
          end

          it 'sets passed full_page_screenshot' do
            opt = Options.new(full_page_screenshot: true)
            expect(opt.full_page_screenshot).to eq(true)
          end

          it 'sets passed ensure_clean_session' do
            opt = Options.new(ensure_clean_session: true)
            expect(opt.ensure_clean_session).to eq(true)
          end

          it 'sets passed file_upload_dialog_timeout' do
            opt = Options.new(file_upload_dialog_timeout: 30000)
            expect(opt.file_upload_dialog_timeout).to eq(30000)
          end

          it 'sets passed force_create_process_api' do
            opt = Options.new(force_create_process_api: true)
            expect(opt.force_create_process_api).to eq(true)
          end

          it 'sets passed force_shell_windows_api' do
            opt = Options.new(force_shell_windows_api: true)
            expect(opt.force_shell_windows_api).to eq(true)
          end

          it 'sets passed ignore_protected_mode_settings' do
            opt = Options.new(ignore_protected_mode_settings: true)
            expect(opt.ignore_protected_mode_settings).to eq(true)
          end

          it 'sets passed ignore_zoom_level' do
            opt = Options.new(ignore_zoom_level: true)
            expect(opt.ignore_zoom_level).to eq(true)
          end

          it 'sets passed initial_browser_url' do
            opt = Options.new(initial_browser_url: 'http://google.com')
            expect(opt.initial_browser_url).to eq('http://google.com')
          end

          it 'sets passed native_events' do
            opt = Options.new(native_events: true)
            expect(opt.native_events).to eq(true)
          end

          it 'sets passed persistent_hover' do
            opt = Options.new(persistent_hover: true)
            expect(opt.persistent_hover).to eq(true)
          end

          it 'sets passed require_window_focus' do
            opt = Options.new(require_window_focus: true)
            expect(opt.require_window_focus).to eq(true)
          end

          it 'sets passed use_per_process_proxy' do
            opt = Options.new(use_per_process_proxy: true)
            expect(opt.use_per_process_proxy).to eq(true)
          end

          it 'sets passed validate_cookie_document_type' do
            opt = Options.new(validate_cookie_document_type: true)
            expect(opt.validate_cookie_document_type).to eq(true)
          end
        end

        describe '#add_argument' do
          it 'adds a command-line argument' do
            subject.add_argument('foo')
            expect(subject.args.to_a).to eq(['foo'])
          end
        end

        describe '#add_option' do
          it 'adds an option' do
            subject.add_option(:foo, 'bar')
            expect(subject.options[:foo]).to eq('bar')
          end
        end

        describe '#as_json' do
          it 'returns a JSON hash' do
            opts = Options.new(args: ['foo'],
                               browser_attach_timeout: 30000,
                               element_scroll_behavior: true,
                               full_page_screenshot: true,
                               ensure_clean_session: true,
                               file_upload_dialog_timeout: 30000,
                               force_create_process_api: true,
                               force_shell_windows_api: true,
                               ignore_protected_mode_settings: false,
                               ignore_zoom_level: false,
                               initial_browser_url: 'http://google.com',
                               native_events: false,
                               persistent_hover: false,
                               require_window_focus: true,
                               use_per_process_proxy: true,
                               validate_cookie_document_type: true)
            opts.add_option(:foo, 'bar')

            json = opts.as_json.fetch('se:ieOptions')

            expect(json['browserAttachTimeout']).to eq(30000)
            expect(json['elementScrollBehavior']).to eq(true)
            expect(json['ie.enableFullPageScreenshot']).to eq(true)
            expect(json['ie.ensureCleanSession']).to eq(true)
            expect(json['ie.fileUploadDialogTimeout']).to eq(30000)
            expect(json['ie.forceCreateProcessApi']).to eq(true)
            expect(json['ie.forceShellWindowsApi']).to eq(true)
            expect(json['ignoreProtectedModeSettings']).to eq(false)
            expect(json['ignoreZoomSetting']).to eq(false)
            expect(json['initialBrowserUrl']).to eq('http://google.com')
            expect(json['nativeEvents']).to eq(true)
            expect(json['enablePersistentHover']).to eq(false)
            expect(json['requireWindowFocus']).to eq(true)
            expect(json['ie.usePerProcessProxy']).to eq(true)
            expect(json['ie.validateCookieDocumentType']).to eq(true)
            expect(json[:foo]).to eq('bar')
          end
        end
      end # Options
    end # IE
  end # WebDriver
end # Selenium
