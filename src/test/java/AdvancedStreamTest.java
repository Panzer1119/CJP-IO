/*
 *    Copyright 2018 Paul Hagedorn (Panzer1119)
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

import de.codemakers.io.streams.AdvancedInputStream;
import de.codemakers.io.streams.AdvancedOutputStream;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.zip.GZIPOutputStream;

public class AdvancedStreamTest {
    
    public static final void main(String[] args) throws Exception {
        final AdvancedOutputStream<PrintStream> system_output_stream = new AdvancedOutputStream<>(System.out);
        final AdvancedOutputStream<PrintStream> system_error_stream = new AdvancedOutputStream<>(System.err);
        final AdvancedInputStream<InputStream> system_input_stream = new AdvancedInputStream<>(System.in);
        //
        final AdvancedOutputStream<ByteArrayOutputStream> test_output_stream = new AdvancedOutputStream<>(new ByteArrayOutputStream());
        //
        final AdvancedOutputStream<GZIPOutputStream> test_output_stream_gzip = test_output_stream.asGZIP();
        //
        final String test = "Test String";
        test_output_stream_gzip.getStream().write(test.getBytes(), 0, test.length());
        test_output_stream_gzip.getStream().flush();
    }
    
}
