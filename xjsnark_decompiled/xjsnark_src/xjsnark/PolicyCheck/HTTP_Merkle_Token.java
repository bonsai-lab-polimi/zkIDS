package xjsnark.PolicyCheck;

/*Generated by MPS */

import backend.structure.CircuitGenerator;
import backend.config.Config;
import backend.eval.SampleRun;
import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import backend.auxTypes.UnsignedInteger;
import backend.auxTypes.FieldElement;
import util.Util;
import xjsnark.tls13_key_schedules.TLSKeySchedule;
import xjsnark.membership_merkle.membership_proof_functions;
import backend.eval.CircuitEvaluator;

public class HTTP_Merkle_Token extends CircuitGenerator {



  public static void main(String[] args) {
    Config.multivariateExpressionMinimization = false;
    Config.writeCircuits = true;
    Config.outputFilesPath = ".";
    transcript_path = args[1];
    merkle_path = args[2];
    token_str = args[3];
    randomid = args[4];
    pktnum = args[5];
    new HTTP_Merkle_Token(args);
  }

  public HTTP_Merkle_Token(String[] s) {
    super("HTTP_Merkle_Token");
    __generateCircuit();
    if (s[0].equals("pub")) {
      System.out.println("Generate public inputs only");
      this.__generatePublicInputs(new SampleRun(randomid + pktnum, true) {
        public void pre() {
          // **************** Channel Opening Inputs ***************************************** 
          try {
            System.out.println(transcript_path);
            System.out.println(merkle_path);
            System.out.println(token_str);

            BufferedReader br = new BufferedReader(new FileReader(transcript_path));
            String psk_line = br.readLine();
            String sk_line = br.readLine();
            String Ax_line = br.readLine();
            String Ay_line = br.readLine();
            String Bx_line = br.readLine();
            String By_line = br.readLine();
            String HS_line = br.readLine();
            String H2_line = br.readLine();
            String H7_line = br.readLine();
            String H3_line = br.readLine();
            String SF_line = br.readLine();
            String pt2_line = br.readLine();
            String enc_ext_line = br.readLine();
            String cert_line = br.readLine();
            String cert_verify_line = br.readLine();
            String serverfinished_line = br.readLine();
            String dns_ct_line = br.readLine();
            String H_state_tr7_line = br.readLine();

            String ct3_line = enc_ext_line + cert_line + cert_verify_line + serverfinished_line;
            for (int i = 0; i < HS_line.length() / 2; i = i + 1) {
              HS[i].mapValue(new BigInteger(HS_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            for (int i = 0; i < H2_line.length() / 2; i = i + 1) {
              H2[i].mapValue(new BigInteger(H2_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            TR3_len.mapValue(BigInteger.valueOf(pt2_line.length() / 2 + ct3_line.length() / 2), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            CertVerify_len.mapValue(BigInteger.valueOf(cert_verify_line.length() / 2), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

            // Compute the tail 
            // This is used for efficient SHA computation 
            String ct3_tail_str = get_tail_minus_36(pt2_line + ct3_line);
            int upperbound = ((ct3_tail_str.length() / 2) - (serverfinished_line.length() / 2));

            for (int i = 0; i < upperbound; i = i + 1) {
              CertVerify_ct_tail[i].mapValue(new BigInteger(ct3_tail_str.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            CertVerify_tail_len.mapValue(BigInteger.valueOf(upperbound), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

            for (int i = upperbound; i < 128; i = i + 1) {
              CertVerify_ct_tail[i].mapValue(new BigInteger("0"), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }
            for (int i = 0; i < 36; i = i + 1) {
              ServerFinished_ct[i].mapValue(new BigInteger(serverfinished_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            // read the H_state 
            for (int i = 0; i < H_state_tr7_line.length() / 2; i = i + 1) {
              SHA_H_Checkpoint[i].mapValue(new BigInteger(H_state_tr7_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            for (int i = 0; i < dns_ct_line.length() / 2; i = i + 1) {
              appl_ct[i].mapValue(new BigInteger(dns_ct_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }
            for (int i = dns_ct_line.length() / 2; i < MAX_DNS_CT_LEN; i = i + 1) {
              appl_ct[i].mapValue(new BigInteger("0"), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

          } catch (Exception ex) {
            System.out.println("Error reading TLS parameters file");
          }

          try {
            // token conversion and assignment 
            int[] conv_token = str_to_array(token_str);
            for (int i = 0; i < TOKEN_LEN; i++) {
              System.out.println(conv_token[i]);
              token[i].mapValue(BigInteger.valueOf(conv_token[i]), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }
            token_length.mapValue(BigInteger.valueOf(conv_token.length), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            System.out.println(conv_token.length);

          } catch (Exception ex) {
            System.out.println("Error with conversions");
          }

          // *************************** Read inputs for Membership Testing ********************* 

          String line;
          try {
            BufferedReader br = new BufferedReader(new FileReader(merkle_path));
            // there are 14 data points in the text file, only some of which are used in this circuit 

            line = br.readLine();
            root.mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            for (int i = 0; i < 255; i++) {
              line = br.readLine();
              tree_leaf[i].mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            // path of left and right, it's F_p[HEIGHT] elements storing the hashes in the path 
            for (int i = 0; i < 4; i++) {
              line = br.readLine();
              auth_path[i].mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }
            line = br.readLine();
            direction.mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

            line = br.readLine();
            leaf_length.mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

          } catch (Exception ex) {
            System.out.println("Error reading Merkle Proof file.");
          }
        }
        public void post() {
          System.out.println("Circuit Output: ");

          for (int j = 0; j < values.length; j++) {
            for (int i = 0; i < values[j].length; i++) {
              System.out.print(String.format("%1$02x", values[j][i].getValueFromEvaluator(CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator())));
            }
            System.out.print("\n");
          }

        }

      });
    } else if (s[0].equals("run")) {
      System.out.println("Normal execution");
      this.__evaluateSampleRun(new SampleRun("randomid + pktnum", true) {
        public void pre() {
          // **************** Channel Opening Inputs ***************************************** 
          try {
            System.out.println(transcript_path);
            System.out.println(merkle_path);
            System.out.println(token_str);

            BufferedReader br = new BufferedReader(new FileReader(transcript_path));
            String psk_line = br.readLine();
            String sk_line = br.readLine();
            String Ax_line = br.readLine();
            String Ay_line = br.readLine();
            String Bx_line = br.readLine();
            String By_line = br.readLine();
            String HS_line = br.readLine();
            String H2_line = br.readLine();
            String H7_line = br.readLine();
            String H3_line = br.readLine();
            String SF_line = br.readLine();
            String pt2_line = br.readLine();
            String enc_ext_line = br.readLine();
            String cert_line = br.readLine();
            String cert_verify_line = br.readLine();
            String serverfinished_line = br.readLine();
            String dns_ct_line = br.readLine();
            String H_state_tr7_line = br.readLine();

            String ct3_line = enc_ext_line + cert_line + cert_verify_line + serverfinished_line;
            for (int i = 0; i < HS_line.length() / 2; i = i + 1) {
              HS[i].mapValue(new BigInteger(HS_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            for (int i = 0; i < H2_line.length() / 2; i = i + 1) {
              H2[i].mapValue(new BigInteger(H2_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            TR3_len.mapValue(BigInteger.valueOf(pt2_line.length() / 2 + ct3_line.length() / 2), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            CertVerify_len.mapValue(BigInteger.valueOf(cert_verify_line.length() / 2), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

            // Compute the tail 
            // This is used for efficient SHA computation 
            String ct3_tail_str = get_tail_minus_36(pt2_line + ct3_line);
            int upperbound = ((ct3_tail_str.length() / 2) - (serverfinished_line.length() / 2));

            for (int i = 0; i < upperbound; i = i + 1) {
              CertVerify_ct_tail[i].mapValue(new BigInteger(ct3_tail_str.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            CertVerify_tail_len.mapValue(BigInteger.valueOf(upperbound), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

            for (int i = upperbound; i < 128; i = i + 1) {
              CertVerify_ct_tail[i].mapValue(new BigInteger("0"), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }
            for (int i = 0; i < 36; i = i + 1) {
              ServerFinished_ct[i].mapValue(new BigInteger(serverfinished_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            // read the H_state 
            for (int i = 0; i < H_state_tr7_line.length() / 2; i = i + 1) {
              SHA_H_Checkpoint[i].mapValue(new BigInteger(H_state_tr7_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            for (int i = 0; i < dns_ct_line.length() / 2; i = i + 1) {
              appl_ct[i].mapValue(new BigInteger(dns_ct_line.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }
            for (int i = dns_ct_line.length() / 2; i < MAX_DNS_CT_LEN; i = i + 1) {
              appl_ct[i].mapValue(new BigInteger("0"), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

          } catch (Exception ex) {
            System.out.println("Error reading TLS parameters file");
          }

          try {
            // token conversion and assignment 
            int[] conv_token = str_to_array(token_str);
            for (int i = 0; i < TOKEN_LEN; i++) {
              System.out.println(conv_token[i]);
              token[i].mapValue(BigInteger.valueOf(conv_token[i]), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }
            token_length.mapValue(BigInteger.valueOf(conv_token.length), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            System.out.println(conv_token.length);

          } catch (Exception ex) {
            System.out.println("Error with conversions");
          }

          // *************************** Read inputs for Membership Testing ********************* 

          String line;
          try {
            BufferedReader br = new BufferedReader(new FileReader(merkle_path));
            // there are 14 data points in the text file, only some of which are used in this circuit 

            line = br.readLine();
            root.mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            for (int i = 0; i < 255; i++) {
              line = br.readLine();
              tree_leaf[i].mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }

            // path of left and right, it's F_p[HEIGHT] elements storing the hashes in the path 
            for (int i = 0; i < 4; i++) {
              line = br.readLine();
              auth_path[i].mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
            }
            line = br.readLine();
            direction.mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

            line = br.readLine();
            leaf_length.mapValue(new BigInteger(line, 10), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

          } catch (Exception ex) {
            System.out.println("Error reading Merkle Proof file.");
          }
        }
        public void post() {
          System.out.println("Circuit Output: ");

          for (int j = 0; j < values.length; j++) {
            for (int i = 0; i < values[j].length; i++) {
              System.out.print(String.format("%1$02x", values[j][i].getValueFromEvaluator(CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator())));
            }
            System.out.print("\n");
          }

        }

      });
    } else {
      System.out.println("Choose pub to generate public inputs only, run to do the whole execution.");
    }
  }



  public void __init() {
    channel_test_file_name = "test_doh.txt";
    membership_test_file_name = "merkle_witness.txt";
    HEIGHT = 4;
    HS = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{32}, 8);
    SHA_H_Checkpoint = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{32}, 8);
    H2 = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{32}, 8);
    TR3_len = new UnsignedInteger(16, new BigInteger("0"));
    CertVerify_len = new UnsignedInteger(16, new BigInteger("0"));
    CertVerify_tail_len = new UnsignedInteger(8, new BigInteger("0"));
    CertVerify_ct_tail = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{128}, 8);
    ServerFinished_ct = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{36}, 8);
    appl_ct = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{MAX_DNS_CT_LEN}, 8);
    root = new FieldElement(new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"), new BigInteger("0"));
    tree_leaf = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{255}, 8);
    auth_path = (FieldElement[]) FieldElement.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{HEIGHT}, new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));
    direction = new UnsignedInteger(64, new BigInteger("0"));
    leaf_length = new UnsignedInteger(8, new BigInteger("0"));
    url_bytes = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{MAX_URL_LEN}, 8);
    url_length = new UnsignedInteger(8, new BigInteger("0"));
    token = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{TOKEN_LEN}, 8);
    token_length = new UnsignedInteger(8, new BigInteger("0"));
    tokencheck = new UnsignedInteger(1, new BigInteger("0"));
  }

  public String channel_test_file_name;
  public String membership_test_file_name;
  public int HEIGHT;
  public UnsignedInteger[] HS;
  public UnsignedInteger[] SHA_H_Checkpoint;
  public UnsignedInteger[] H2;
  public UnsignedInteger TR3_len;
  public UnsignedInteger CertVerify_len;
  public UnsignedInteger CertVerify_tail_len;
  public UnsignedInteger[] CertVerify_ct_tail;
  public UnsignedInteger[] ServerFinished_ct;
  public UnsignedInteger[] appl_ct;
  public FieldElement root;
  public UnsignedInteger[] tree_leaf;
  public FieldElement[] auth_path;
  public UnsignedInteger direction;
  public UnsignedInteger leaf_length;
  public UnsignedInteger[] url_bytes;
  public UnsignedInteger url_length;
  public UnsignedInteger[] token;
  public UnsignedInteger token_length;
  public UnsignedInteger[][] values;
  public UnsignedInteger tokencheck;
  public UnsignedInteger[] string_http;

  public static String transcript_path;
  public static String merkle_path;
  public static String token_str;
  public static String randomid;
  public static String pktnum;
  public static final int MAX_DNS_CT_LEN = 500;
  public static final int MAX_URL_LEN = 20;
  public static final int TOKEN_LEN = 6;
  @Override
  public void __defineInputs() {
    super.__defineInputs();
    TR3_len = UnsignedInteger.createInput(this, 16);
    CertVerify_len = UnsignedInteger.createInput(this, 16);
    CertVerify_tail_len = UnsignedInteger.createInput(this, 8);
    token_length = UnsignedInteger.createInput(this, 8);
    root = FieldElement.createInput(this, new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));



    H2 = (UnsignedInteger[]) UnsignedInteger.createInputArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(H2), 8);
    CertVerify_ct_tail = (UnsignedInteger[]) UnsignedInteger.createInputArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(CertVerify_ct_tail), 8);
    ServerFinished_ct = (UnsignedInteger[]) UnsignedInteger.createInputArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(ServerFinished_ct), 8);
    token = (UnsignedInteger[]) UnsignedInteger.createInputArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(token), 8);












  }
  @Override
  public void __defineOutputs() {
    super.__defineOutputs();









  }
  @Override
  public void __defineVerifiedWitnesses() {
    super.__defineVerifiedWitnesses();

    direction = UnsignedInteger.createVerifiedWitness(this, 64);
    leaf_length = UnsignedInteger.createVerifiedWitness(this, 8);



    HS = (UnsignedInteger[]) UnsignedInteger.createVerifiedWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(HS), 8);
    SHA_H_Checkpoint = (UnsignedInteger[]) UnsignedInteger.createVerifiedWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(SHA_H_Checkpoint), 8);
    appl_ct = (UnsignedInteger[]) UnsignedInteger.createVerifiedWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(appl_ct), 8);
    tree_leaf = (UnsignedInteger[]) UnsignedInteger.createVerifiedWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(tree_leaf), 8);

    auth_path = (FieldElement[]) FieldElement.createVerifiedWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(auth_path), new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));














  }
  @Override
  public void __defineWitnesses() {
    super.__defineWitnesses();

















  }
  public void outsource() {

    // ********************* Channel Opening ********************** 

    UnsignedInteger[] SHA_H_Checkpoint_32 = xjsnark.util_and_sha.Util.convert_8_to_32(SHA_H_Checkpoint);
    values = TLSKeySchedule.get1RTT_HS_new(HS, H2, TR3_len.copy(16), CertVerify_len.copy(16), CertVerify_ct_tail, ServerFinished_ct, CertVerify_tail_len.copy(8), SHA_H_Checkpoint_32, appl_ct);
    tokencheck.assign(LabelExtraction.check_token(values[0], token, token_length.copy(8)), 1);
    UnsignedInteger a = new UnsignedInteger(1, new BigInteger("0"));
    a.assign(membership_proof_functions.membershipProofChecks(values[0], root.copy(), tree_leaf, leaf_length.copy(8), auth_path, direction.copy(64)), 1);

  }
  public String get_tail_minus_36(String line) {
    String output = "";
    int len = (line.length() / 2);
    int num_whole_blocks = (len - 36) / 64;
    int tail_len = len - num_whole_blocks * 64;
    for (int i = 0; i < tail_len; i++) {
      int j = num_whole_blocks * 64 + i;
      output = output + line.substring(2 * j, 2 * j + 2);
    }
    return output;
  }
  public int[] str_to_array(String str) {
    int[] asciiVal = new int[str.length()];
    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      asciiVal[i] = Character.codePointAt(Character.toString(c), 0);
    }
    return asciiVal;
  }

  public void __generateSampleInput(CircuitEvaluator evaluator) {
    __generateRandomInput(evaluator);
  }

}
