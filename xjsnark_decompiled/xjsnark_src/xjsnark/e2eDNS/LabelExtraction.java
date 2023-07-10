package xjsnark.e2eDNS;

/*Generated by MPS */

import backend.auxTypes.SmartMemory;
import backend.auxTypes.UnsignedInteger;
import backend.structure.CircuitGenerator;
import backend.auxTypes.Bit;
import backend.auxTypes.ConditionalScopeTracker;
import java.math.BigInteger;

public class LabelExtraction {
  public static final int[] b64url_encoding_table_int = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

  public static final int[] base64_decode_table = {0xab, 0x76, 0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0, 0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15, 0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x11, 62, 0, 0, 0, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 0, 0, 0, 0, 0, 0, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 0, 0, 0, 0, 0};

  // The string 'HTTP/1.1' in ASCII
  public static final int[] http11_ints = {0x48, 0x54, 0x54, 0x50, 0x2f, 0x31, 0x2e, 0x31};
  public static final int[] query_ints = {0x2F, 0x64, 0x6e, 0x73, 0x2d, 0x71, 0x75, 0x65, 0x72, 0x79};


  public static SmartMemory<UnsignedInteger> b64_decode_ram;

  public static final int[] first_four_post_ints = {80, 79, 83, 84};
  public static final int[] first_four_get_bytes_int = {71, 69, 84, 32};

  public static final int cr_int = 0x0d;
  public static final int lf_int = 0x0a;

  public static final int HTTP_REQUEST_MAX_LENGTH = 500;
  public static final int DNS_QUERY_MAX_LENGTH = 255;

  public static final int DNS_QUERY_MAX_B64_LENGTH = 344;

  public static UnsignedInteger[][] deserializeQuestion(UnsignedInteger[] dns_message, int offset) {
    UnsignedInteger skip_index = UnsignedInteger.instantiateFrom(8, offset).copy(8);

    UnsignedInteger[] all_labels = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{255}, 8);

    UnsignedInteger true_length = UnsignedInteger.instantiateFrom(8, 0).copy(8);

    UnsignedInteger keep_reading = UnsignedInteger.instantiateFrom(1, 1).copy(1);

    for (int i = 0; i + offset < 255; i++) {
      {
        Bit bit_a0i0w = UnsignedInteger.instantiateFrom(8, i + offset).isNotEqualTo(skip_index).copy();
        boolean c_a0i0w = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0i0w);
        if (c_a0i0w) {
          if (bit_a0i0w.getConstantValue()) {
            all_labels[i].assign(dns_message[i + offset].mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);
          } else {
            {
              Bit bit_a0a0a0a2a0a8a22 = dns_message[i + offset].isNotEqualTo(UnsignedInteger.instantiateFrom(8, 0)).copy();
              boolean c_a0a0a0a2a0a8a22 = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0a0a0a2a0a8a22);
              if (c_a0a0a0a2a0a8a22) {
                if (bit_a0a0a0a2a0a8a22.getConstantValue()) {
                  true_length.assign(true_length.add(dns_message[i + offset]).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                  skip_index.assign(skip_index.add(dns_message[i + offset]).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                  all_labels[i].assign(UnsignedInteger.instantiateFrom(8, 46).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);
                } else {
                  keep_reading.assign(UnsignedInteger.instantiateFrom(1, 0), 1);

                }
              } else {
                ConditionalScopeTracker.pushMain();
                ConditionalScopeTracker.push(bit_a0a0a0a2a0a8a22);
                true_length.assign(true_length.add(dns_message[i + offset]).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                skip_index.assign(skip_index.add(dns_message[i + offset]).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                all_labels[i].assign(UnsignedInteger.instantiateFrom(8, 46).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);

                ConditionalScopeTracker.pop();

                ConditionalScopeTracker.push(new Bit(true));

                keep_reading.assign(UnsignedInteger.instantiateFrom(1, 0), 1);
                ConditionalScopeTracker.pop();
                ConditionalScopeTracker.popMain();
              }

            }

          }
        } else {
          ConditionalScopeTracker.pushMain();
          ConditionalScopeTracker.push(bit_a0i0w);
          all_labels[i].assign(dns_message[i + offset].mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);

          ConditionalScopeTracker.pop();

          ConditionalScopeTracker.push(new Bit(true));

          {
            Bit bit_a0a0a8a22_0 = dns_message[i + offset].isNotEqualTo(UnsignedInteger.instantiateFrom(8, 0)).copy();
            boolean c_a0a0a8a22_0 = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0a0a8a22_0);
            if (c_a0a0a8a22_0) {
              if (bit_a0a0a8a22_0.getConstantValue()) {
                true_length.assign(true_length.add(dns_message[i + offset]).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                skip_index.assign(skip_index.add(dns_message[i + offset]).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                all_labels[i].assign(UnsignedInteger.instantiateFrom(8, 46).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);
              } else {
                keep_reading.assign(UnsignedInteger.instantiateFrom(1, 0), 1);

              }
            } else {
              ConditionalScopeTracker.pushMain();
              ConditionalScopeTracker.push(bit_a0a0a8a22_0);
              true_length.assign(true_length.add(dns_message[i + offset]).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
              skip_index.assign(skip_index.add(dns_message[i + offset]).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
              all_labels[i].assign(UnsignedInteger.instantiateFrom(8, 46).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);

              ConditionalScopeTracker.pop();

              ConditionalScopeTracker.push(new Bit(true));

              keep_reading.assign(UnsignedInteger.instantiateFrom(1, 0), 1);
              ConditionalScopeTracker.pop();
              ConditionalScopeTracker.popMain();
            }

          }
          ConditionalScopeTracker.pop();
          ConditionalScopeTracker.popMain();
        }

      }
    }


    return new UnsignedInteger[][]{all_labels, new UnsignedInteger[]{true_length.copy(8)}};
  }


  public static UnsignedInteger[][] deserializeQuestion(UnsignedInteger[] dns_message, UnsignedInteger offset) {

    SmartMemory<UnsignedInteger> dns_message_ram = new SmartMemory(dns_message, UnsignedInteger.__getClassRef(), new Object[]{"8"});

    UnsignedInteger skip_index = UnsignedInteger.instantiateFrom(8, offset).copy(8);

    UnsignedInteger[] all_labels = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{255}, 8);

    UnsignedInteger true_length = UnsignedInteger.instantiateFrom(8, 0).copy(8);

    UnsignedInteger keep_reading = UnsignedInteger.instantiateFrom(1, 1).copy(1);


    for (int i = 0; i < 255; i++) {
      {
        Bit bit_a0m0z = UnsignedInteger.instantiateFrom(8, i).add(offset).isNotEqualTo(skip_index).copy();
        boolean c_a0m0z = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0m0z);
        if (c_a0m0z) {
          if (bit_a0m0z.getConstantValue()) {
            all_labels[i].assign(UnsignedInteger.instantiateFrom(8, dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset))).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);
          } else {
            {
              Bit bit_a0a0a0a2a0a21a52 = dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset)).isNotEqualTo(UnsignedInteger.instantiateFrom(8, 0)).copy();
              boolean c_a0a0a0a2a0a21a52 = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0a0a0a2a0a21a52);
              if (c_a0a0a0a2a0a21a52) {
                if (bit_a0a0a0a2a0a21a52.getConstantValue()) {
                  true_length.assign(true_length.add(UnsignedInteger.instantiateFrom(8, dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset)))).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                  skip_index.assign(skip_index.add(dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset))).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                  all_labels[i].assign(UnsignedInteger.instantiateFrom(8, 46).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);
                } else {
                  keep_reading.assign(UnsignedInteger.instantiateFrom(1, 0), 1);

                }
              } else {
                ConditionalScopeTracker.pushMain();
                ConditionalScopeTracker.push(bit_a0a0a0a2a0a21a52);
                true_length.assign(true_length.add(UnsignedInteger.instantiateFrom(8, dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset)))).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                skip_index.assign(skip_index.add(dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset))).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                all_labels[i].assign(UnsignedInteger.instantiateFrom(8, 46).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);

                ConditionalScopeTracker.pop();

                ConditionalScopeTracker.push(new Bit(true));

                keep_reading.assign(UnsignedInteger.instantiateFrom(1, 0), 1);
                ConditionalScopeTracker.pop();
                ConditionalScopeTracker.popMain();
              }

            }

          }
        } else {
          ConditionalScopeTracker.pushMain();
          ConditionalScopeTracker.push(bit_a0m0z);
          all_labels[i].assign(UnsignedInteger.instantiateFrom(8, dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset))).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);

          ConditionalScopeTracker.pop();

          ConditionalScopeTracker.push(new Bit(true));

          {
            Bit bit_a0a0a21a52_0 = dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset)).isNotEqualTo(UnsignedInteger.instantiateFrom(8, 0)).copy();
            boolean c_a0a0a21a52_0 = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0a0a21a52_0);
            if (c_a0a0a21a52_0) {
              if (bit_a0a0a21a52_0.getConstantValue()) {
                true_length.assign(true_length.add(UnsignedInteger.instantiateFrom(8, dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset)))).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                skip_index.assign(skip_index.add(dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset))).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
                all_labels[i].assign(UnsignedInteger.instantiateFrom(8, 46).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);
              } else {
                keep_reading.assign(UnsignedInteger.instantiateFrom(1, 0), 1);

              }
            } else {
              ConditionalScopeTracker.pushMain();
              ConditionalScopeTracker.push(bit_a0a0a21a52_0);
              true_length.assign(true_length.add(UnsignedInteger.instantiateFrom(8, dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset)))).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
              skip_index.assign(skip_index.add(dns_message_ram.read(UnsignedInteger.instantiateFrom(8, i).add(offset))).add(UnsignedInteger.instantiateFrom(8, 1)), 8);
              all_labels[i].assign(UnsignedInteger.instantiateFrom(8, 46).mul(UnsignedInteger.instantiateFrom(8, keep_reading)), 8);

              ConditionalScopeTracker.pop();

              ConditionalScopeTracker.push(new Bit(true));

              keep_reading.assign(UnsignedInteger.instantiateFrom(1, 0), 1);
              ConditionalScopeTracker.pop();
              ConditionalScopeTracker.popMain();
            }

          }
          ConditionalScopeTracker.pop();
          ConditionalScopeTracker.popMain();
        }

      }
    }

    return new UnsignedInteger[][]{all_labels, new UnsignedInteger[]{true_length.copy(8)}};
  }



  public static UnsignedInteger[][] extractDoT(UnsignedInteger[] dns_message) {

    return deserializeQuestion(dns_message, 14);

  }

  public static UnsignedInteger[][] extractDoTReverse(UnsignedInteger[] dns_message) {

    UnsignedInteger[][] return_values = extractDoT(dns_message);

    UnsignedInteger[] all_labels = return_values[0];
    UnsignedInteger true_length = return_values[1][0].copy(8);

    UnsignedInteger[] reverse_label = reverse(all_labels, true_length.copy(8));

    return new UnsignedInteger[][]{reverse_label, new UnsignedInteger[]{true_length.copy(8)}};
  }


  private static void check_method(SmartMemory<UnsignedInteger> http_bytes_ram, UnsignedInteger[] first_four_post) {
    for (int i = 0; i < 4; i++) {
      http_bytes_ram.read(i).forceEqual(first_four_post[i]);
    }
  }

  private static void check_crlf_index(SmartMemory<UnsignedInteger> http_bytes_ram, UnsignedInteger crlf_index) {

    UnsignedInteger cr = UnsignedInteger.instantiateFrom(8, 13).copy(8);
    UnsignedInteger lf = UnsignedInteger.instantiateFrom(8, 10).copy(8);

    http_bytes_ram.read(crlf_index).forceEqual(cr);
    http_bytes_ram.read(crlf_index.add(UnsignedInteger.instantiateFrom(16, 1))).forceEqual(lf);
    http_bytes_ram.read(crlf_index.add(UnsignedInteger.instantiateFrom(16, 2))).forceEqual(cr);
    http_bytes_ram.read(crlf_index.add(UnsignedInteger.instantiateFrom(16, 3))).forceEqual(lf);
  }


  public static UnsignedInteger[][] extractDoHPOST(UnsignedInteger[] http_bytes, UnsignedInteger crlf_index) {

    SmartMemory<UnsignedInteger> http_bytes_ram = new SmartMemory(http_bytes, UnsignedInteger.__getClassRef(), new Object[]{"8"});
    UnsignedInteger[] first_four_post = UnsignedInteger.instantiateFrom(8, first_four_post_ints);


    check_method(http_bytes_ram, first_four_post);

    check_crlf_index(http_bytes_ram, crlf_index.copy(16));


    UnsignedInteger[][] return_values = deserializeQuestion(http_bytes, crlf_index.add(UnsignedInteger.instantiateFrom(8, 16)).copy(8));

    return return_values;
  }

  public static UnsignedInteger[][] extractDoHPOSTReverse(UnsignedInteger[] http_bytes, UnsignedInteger crlf_index) {

    UnsignedInteger[][] return_values = extractDoHPOST(http_bytes, crlf_index.copy(8));

    UnsignedInteger[] all_labels = return_values[0];
    UnsignedInteger true_length = return_values[1][0].copy(8);

    UnsignedInteger[] reverse_label = reverse(all_labels, true_length.copy(8));


    // first verify that the query is a p 

    return new UnsignedInteger[][]{reverse_label, new UnsignedInteger[]{true_length.copy(8)}};
  }


  public static UnsignedInteger decode_base64_character(UnsignedInteger ch) {
    UnsignedInteger output = new UnsignedInteger(8, new BigInteger("0"));

    output.assign(UnsignedInteger.instantiateFrom(8, b64_decode_ram.read(UnsignedInteger.instantiateFrom(8, ch))), 8);

    return output;
  }

  // GET AND ALL THE BASE64 STUFF

  public static UnsignedInteger[] convert_one_base64_block(UnsignedInteger[] input) {

    UnsignedInteger one_block = UnsignedInteger.instantiateFrom(24, 0).copy(24);

    UnsignedInteger converted_value = new UnsignedInteger(8, new BigInteger("0"));

    for (int j = 0; j < 4; j++) {
      converted_value.assign(decode_base64_character(input[j].copy(8)), 8);
      one_block.assign(one_block.orBitwise((UnsignedInteger.instantiateFrom(24, converted_value).shiftLeft((6 * (3 - j))))), 24);
    }

    UnsignedInteger[] output = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{3}, 8);

    for (int i = 0; i < 3; i++) {
      output[i].assign(UnsignedInteger.instantiateFrom(8, one_block.shiftRight((8 * (2 - i)))), 8);
    }

    return output;
  }

  // input has length 344
  public static UnsignedInteger[] convert_base64_to_ascii(UnsignedInteger[] input, UnsignedInteger length) {

    UnsignedInteger[] output = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{258}, 8);

    UnsignedInteger[] four_bytes = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{4}, 8);
    UnsignedInteger[] block = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{3}, 8);

    for (int i = 0; i < 86; i++) {
      // take 4 bytes and convert each via the table from b64 to ascii 
      for (int j = 0; j < 4; j++) {
        four_bytes[j].assign(input[i * 4 + j], 8);
      }

      block = convert_one_base64_block(four_bytes);

      for (int k = 0; k < 3; k++) {
        output[i * 3 + k].assign(block[k], 8);
      }
    }

    return output;
  }



  // http bytes has to have length more than 255+19
  public static UnsignedInteger[][] extractDoHGET(UnsignedInteger[] http_bytes) {

    SmartMemory<UnsignedInteger> http_bytes_ram = new SmartMemory(http_bytes, UnsignedInteger.__getClassRef(), new Object[]{"8"});

    b64_decode_ram = new SmartMemory(UnsignedInteger.instantiateFrom(8, base64_decode_table), UnsignedInteger.__getClassRef(), new Object[]{"8"});


    // first verify that the query is a post 
    UnsignedInteger[] first_four_get = UnsignedInteger.instantiateFrom(8, first_four_get_bytes_int);
    check_method(http_bytes_ram, first_four_get);

    // we will skip the first   
    UnsignedInteger[] wire_format_base64 = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{DNS_QUERY_MAX_B64_LENGTH}, 8);

    UnsignedInteger seen_space = UnsignedInteger.instantiateFrom(1, 0).copy(1);
    UnsignedInteger wf_length = UnsignedInteger.instantiateFrom(16, 0).copy(16);
    for (int i = 0; i < DNS_QUERY_MAX_B64_LENGTH; i++) {
      {
        Bit bit_a0p0ec = seen_space.isEqualTo(UnsignedInteger.instantiateFrom(1, 0)).copy();
        boolean c_a0p0ec = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0p0ec);
        if (c_a0p0ec) {
          if (bit_a0p0ec.getConstantValue()) {
            {
              Bit bit_a0a0a2a0a51a65 = http_bytes[i + 19].isNotEqualTo(UnsignedInteger.instantiateFrom(8, 32)).copy();
              boolean c_a0a0a2a0a51a65 = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0a0a2a0a51a65);
              if (c_a0a0a2a0a51a65) {
                if (bit_a0a0a2a0a51a65.getConstantValue()) {
                  wire_format_base64[i].assign(http_bytes[i + 19], 8);
                  wf_length.assign(wf_length.add(UnsignedInteger.instantiateFrom(16, 1)), 16);
                } else {
                  seen_space.assign(UnsignedInteger.instantiateFrom(1, 1), 1);

                }
              } else {
                ConditionalScopeTracker.pushMain();
                ConditionalScopeTracker.push(bit_a0a0a2a0a51a65);
                wire_format_base64[i].assign(http_bytes[i + 19], 8);
                wf_length.assign(wf_length.add(UnsignedInteger.instantiateFrom(16, 1)), 16);

                ConditionalScopeTracker.pop();

                ConditionalScopeTracker.push(new Bit(true));

                seen_space.assign(UnsignedInteger.instantiateFrom(1, 1), 1);
                ConditionalScopeTracker.pop();
                ConditionalScopeTracker.popMain();
              }

            }
          } else {
            wire_format_base64[i].assign(UnsignedInteger.instantiateFrom(8, 0), 8);

          }
        } else {
          ConditionalScopeTracker.pushMain();
          ConditionalScopeTracker.push(bit_a0p0ec);
          {
            Bit bit_a0a0p0ec = http_bytes[i + 19].isNotEqualTo(UnsignedInteger.instantiateFrom(8, 32)).copy();
            boolean c_a0a0p0ec = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0a0p0ec);
            if (c_a0a0p0ec) {
              if (bit_a0a0p0ec.getConstantValue()) {
                wire_format_base64[i].assign(http_bytes[i + 19], 8);
                wf_length.assign(wf_length.add(UnsignedInteger.instantiateFrom(16, 1)), 16);
              } else {
                seen_space.assign(UnsignedInteger.instantiateFrom(1, 1), 1);

              }
            } else {
              ConditionalScopeTracker.pushMain();
              ConditionalScopeTracker.push(bit_a0a0p0ec);
              wire_format_base64[i].assign(http_bytes[i + 19], 8);
              wf_length.assign(wf_length.add(UnsignedInteger.instantiateFrom(16, 1)), 16);

              ConditionalScopeTracker.pop();

              ConditionalScopeTracker.push(new Bit(true));

              seen_space.assign(UnsignedInteger.instantiateFrom(1, 1), 1);
              ConditionalScopeTracker.pop();
              ConditionalScopeTracker.popMain();
            }

          }

          ConditionalScopeTracker.pop();

          ConditionalScopeTracker.push(new Bit(true));

          wire_format_base64[i].assign(UnsignedInteger.instantiateFrom(8, 0), 8);
          ConditionalScopeTracker.pop();
          ConditionalScopeTracker.popMain();
        }

      }
    }

    UnsignedInteger[] converted;
    converted = convert_base64_to_ascii(wire_format_base64, wf_length.copy(16));

    UnsignedInteger[][] return_values = deserializeQuestion(converted, 12);
    UnsignedInteger[] all_labels = return_values[0];
    UnsignedInteger true_length = return_values[1][0].copy(8);


    return new UnsignedInteger[][]{all_labels, return_values[1]};
  }

  public static UnsignedInteger[][] extractDoHGETReverse(UnsignedInteger[] http_bytes) {


    UnsignedInteger[][] return_values = extractDoHGET(http_bytes);

    UnsignedInteger[] all_labels = return_values[0];
    UnsignedInteger true_length = return_values[1][0].copy(8);


    UnsignedInteger[] reverse_label = reverse(all_labels, true_length.copy(8));


    return new UnsignedInteger[][]{reverse_label, new UnsignedInteger[]{true_length.copy(8)}};
  }

  public static UnsignedInteger[] reverse(UnsignedInteger[] input, UnsignedInteger rev_length) {

    SmartMemory<UnsignedInteger> input_ram = new SmartMemory(input, UnsignedInteger.__getClassRef(), new Object[]{"8"});
    UnsignedInteger[] output = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{input.length}, 8);

    for (int i = 0; i < input.length; i++) {
      {
        Bit bit_a0e0ic = UnsignedInteger.instantiateFrom(8, i).isLessThan(rev_length).copy();
        boolean c_a0e0ic = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0e0ic);
        if (c_a0e0ic) {
          if (bit_a0e0ic.getConstantValue()) {
            output[i].assign(input_ram.read(UnsignedInteger.instantiateFrom(8, rev_length.subtract(UnsignedInteger.instantiateFrom(8, i)).subtract(UnsignedInteger.instantiateFrom(8, 1)))), 8);
          } else {

          }
        } else {
          ConditionalScopeTracker.pushMain();
          ConditionalScopeTracker.push(bit_a0e0ic);
          output[i].assign(input_ram.read(UnsignedInteger.instantiateFrom(8, rev_length.subtract(UnsignedInteger.instantiateFrom(8, i)).subtract(UnsignedInteger.instantiateFrom(8, 1)))), 8);

          ConditionalScopeTracker.pop();

          ConditionalScopeTracker.push(new Bit(true));

          ConditionalScopeTracker.pop();
          ConditionalScopeTracker.popMain();
        }

      }
    }

    return output;
  }


  public static UnsignedInteger[] concat(UnsignedInteger[] a1, UnsignedInteger[] a2) {
    int l1 = a1.length;
    int l2 = a2.length;
    UnsignedInteger[] res = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{l1 + l2}, 8);

    for (int i = 0; i < l1; i++) {
      res[i].assign(a1[i], 8);
    }

    for (int i = 0; i < l2; i++) {
      res[i + l1].assign(a2[i], 8);
    }
    return res;

  }


  // This function searches through the entire http message
  // and returns the first index with character CR that is followed by character LF
  // That is, http_msg[i] || http_msg[i+1] = CR || LF 
  private static UnsignedInteger get_first_crlf_index(UnsignedInteger[] http_msg) {

    UnsignedInteger cr = UnsignedInteger.instantiateFrom(16, cr_int).copy(16);
    UnsignedInteger lf = UnsignedInteger.instantiateFrom(16, lf_int).copy(16);

    // Create one 16-bit integer by concatenating cr and lf 
    UnsignedInteger CRLF_CONCAT = (UnsignedInteger.instantiateFrom(16, cr).shiftLeft(8)).orBitwise((UnsignedInteger.instantiateFrom(16, lf))).copy(16);


    // A bit to indicate if CRLF has been found 
    UnsignedInteger not_found = UnsignedInteger.instantiateFrom(1, 1).copy(1);

    UnsignedInteger first_crlf_index = UnsignedInteger.instantiateFrom(8, 0).copy(8);

    // We must search through the entire message  
    for (int i = 1; i < HTTP_REQUEST_MAX_LENGTH; i++) {

      // Record the current and previous characters 
      UnsignedInteger curr_char = UnsignedInteger.instantiateFrom(16, http_msg[i]).copy(16);
      UnsignedInteger prev_char = http_msg[i - 1].copy(8);

      // Concatenate prev_char || curr_char into one 16 bit integer  
      UnsignedInteger curr_concat = ((UnsignedInteger.instantiateFrom(16, prev_char).shiftLeft(8)).orBitwise(UnsignedInteger.instantiateFrom(16, curr_char))).copy(16);

      // Compare CRLF_CONCAT with the current concatenation 
      {
        Bit bit_j0o0rc = CRLF_CONCAT.isEqualTo(curr_concat).copy();
        boolean c_j0o0rc = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_j0o0rc);
        if (c_j0o0rc) {
          if (bit_j0o0rc.getConstantValue()) {

            // We must set first_crlf_index to be i-1 only the first time we enter this loop. 
            // We could use nested loops, 
            // but we do this funny assignment method because of issues with xJsnark's optimizer with some nested loops. 
            // Note that this if_clause is entered multiple times and only the first entry must be recorded. 
            first_crlf_index.assign(UnsignedInteger.instantiateFrom(8, i - 1).mul(not_found).add(first_crlf_index), 8);

            not_found.assign(UnsignedInteger.instantiateFrom(1, 0), 1);
          } else {

          }
        } else {
          ConditionalScopeTracker.pushMain();
          ConditionalScopeTracker.push(bit_j0o0rc);

          // We must set first_crlf_index to be i-1 only the first time we enter this loop. 
          // We could use nested loops, 
          // but we do this funny assignment method because of issues with xJsnark's optimizer with some nested loops. 
          // Note that this if_clause is entered multiple times and only the first entry must be recorded. 
          first_crlf_index.assign(UnsignedInteger.instantiateFrom(8, i - 1).mul(not_found).add(first_crlf_index), 8);

          not_found.assign(UnsignedInteger.instantiateFrom(1, 0), 1);

          ConditionalScopeTracker.pop();

          ConditionalScopeTracker.push(new Bit(true));

          ConditionalScopeTracker.pop();
          ConditionalScopeTracker.popMain();
        }

      }
    }

    return first_crlf_index;
  }

  // This function verifies that the 8 chars preceding the first_crlf_index in http_msg_ram are 'HTTP/1.1'
  private static void match_http(SmartMemory<UnsignedInteger> http_msg_ram, int first_char_index, UnsignedInteger[] allowed_url, UnsignedInteger url_len) {
    UnsignedInteger[] http11 = UnsignedInteger.instantiateFrom(8, http11_ints);
    UnsignedInteger[] query = UnsignedInteger.instantiateFrom(8, query_ints);
    // Perform the verification using the input RAM 
    // We require a RAM as we access indices based on the first_crlf_index, which is variable 
    // and not known at the creation of the circuit. 
    // TODO: how to make a for with a variable end: PASS THE LENGTH? 
    UnsignedInteger keep_reading = UnsignedInteger.instantiateFrom(1, 1).copy(1);

    for (int i = 0; i < DNS_Shortcut_doh_get.MAX_URL_LEN; i++) {
      {
        Bit bit_a0i0uc = UnsignedInteger.instantiateFrom(8, i).isLessThan(url_len).copy();
        boolean c_a0i0uc = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0i0uc);
        if (c_a0i0uc) {
          if (bit_a0i0uc.getConstantValue()) {
            http_msg_ram.read(first_char_index + i).forceEqual(allowed_url[i]);
          } else {

          }
        } else {
          ConditionalScopeTracker.pushMain();
          ConditionalScopeTracker.push(bit_a0i0uc);
          http_msg_ram.read(first_char_index + i).forceEqual(allowed_url[i]);

          ConditionalScopeTracker.pop();

          ConditionalScopeTracker.push(new Bit(true));

          ConditionalScopeTracker.pop();
          ConditionalScopeTracker.popMain();
        }

      }
      // If verifyEq fails, the proof generation fails 
    }
  }


  // The function does the following;
  // (1) Find the first index where the CRLF characters appear (numbers 13, 10 in decimal)
  // (2) Verify the 8 chars preceding the first CRLF is 'HTTP/1.1'
  public static UnsignedInteger[] firewall(UnsignedInteger[] http_msg, UnsignedInteger[] allowed_url, UnsignedInteger url_length) {
    // Get the first index where CRLF appears 
    for (int i = 0; i < allowed_url.length; i++) {
      CircuitGenerator.__getActiveCircuitGenerator().__addDebugInstruction(allowed_url[i], "mario");
    }
    // TODO: could we use the assumption that the first 4 are "GET "? 
    int first_char_index = 4;
    // Create a RAM from the http message. 
    // RAM is required as the first CRLF location is variable 
    SmartMemory<UnsignedInteger> http_msg_ram = new SmartMemory(UnsignedInteger.instantiateFrom(8, http_msg), UnsignedInteger.__getClassRef(), new Object[]{"8"});

    // Verifies the http string before the CRLF 
    match_http(http_msg_ram, first_char_index, allowed_url, url_length.copy(8));
    for (int i = 0; i < http_msg.length; i++) {
      CircuitGenerator.__getActiveCircuitGenerator().__addDebugInstruction(http_msg[i], "httpmsg");
    }
    return http_msg;
  }
  public static UnsignedInteger check_token(UnsignedInteger[] http_msg, UnsignedInteger[] token, UnsignedInteger token_length) {
    UnsignedInteger secondrow = get_first_crlf_index(http_msg).copy(8);
    SmartMemory<UnsignedInteger> http_msg_ram = new SmartMemory(UnsignedInteger.instantiateFrom(8, http_msg), UnsignedInteger.__getClassRef(), new Object[]{"8"});
    for (int i = 0; i < 6; i++) {
      CircuitGenerator.__getActiveCircuitGenerator().__addDebugInstruction(http_msg_ram.read(secondrow.add(UnsignedInteger.instantiateFrom(8, i)).add(UnsignedInteger.instantiateFrom(8, 14))), "token_message");
      CircuitGenerator.__getActiveCircuitGenerator().__addDebugInstruction(token[i], "token_saved");
    }
    return UnsignedInteger.instantiateFrom(1, 1);
  }


}
