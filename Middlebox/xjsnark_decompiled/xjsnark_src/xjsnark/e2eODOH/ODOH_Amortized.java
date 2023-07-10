package xjsnark.e2eODOH;

/*Generated by MPS */

import backend.structure.CircuitGenerator;
import backend.config.Config;
import backend.eval.SampleRun;
import java.math.BigInteger;
import backend.auxTypes.FieldElement;
import backend.auxTypes.UnsignedInteger;
import util.Util;
import xjsnark.poseidon.PoseidonHash;
import xjsnark.aes_gcm.AES_GCM;
import backend.eval.CircuitEvaluator;

public class ODOH_Amortized extends CircuitGenerator {



  public static void main(String[] args) {
    Config.arithOptimizerNumThreads = 8;
    Config.arithOptimizerIncrementalMode = false;
    Config.multivariateExpressionMinimization = false;

    Config.writeCircuits = true;
    Config.outputFilesPath = ".";

    new ODOH_Amortized();
  }

  public ODOH_Amortized() {
    super("ODOH_Amortized");
    __generateCircuit();
    this.__evaluateSampleRun(new SampleRun("Sample_Run1", true) {
      public void pre() {
        try {

          // CHANNEL OPENINGS INPUT 
          String comm_str = "2db24a9a876fc5395a0a087137c4d73de25a4f2002f384513d8427959247c4cd";
          String key_str = "e1a1786a0c146f4b172192141df6ffd9";
          String iv_str = "cf73d63f3ac141740b84c7fd";

          String dns_ct_str = "00b4b0c1bb3d83e53dc0068f1ec5131866cb450e511f099a7e4b2023117cf33bd169abd26a55c710d9edaa01c8c16d9f10084ba737104cbb11f498a0c273d3cb24330b59eee830973dba4a1bc6d6a554e3e36ac5c303f24e9a8189ab1b6cd09c172bc1ab2d303519f7a0bc07191f3c79e32caeae3de45ac29cee35ec1dc7d9462a2d2f99075c8b840a53f5df1fcb1d80793c1925365f6659c7927b669f3132a8ce12aeffd2131ff540090269db21ee16caf911d3e0764c8c257e2a7fbdc5aef7e6c9868c102d6fb8e1c5d68e966a1085e46a792109e8006763a83063e460419a6302b77f5e19f437b1fabdc4689aa341aef1ac76940c42a27ae10d9424f071d6e28e7f92b95baa727ccfc7e82850c28124c98638e7e8e4855d46ffc32a74";

          comm.mapValue(new BigInteger(comm_str, 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

          for (int i = 0; i < key_str.length() / 2; i = i + 1) {
            key[i].mapValue(new BigInteger(key_str.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
          }

          for (int i = 0; i < iv_str.length() / 2; i = i + 1) {
            iv[i].mapValue(new BigInteger(iv_str.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
          }

          for (int i = 0; i < dns_ct_str.length() / 2; i = i + 1) {
            http_bytes_ciphertext[i].mapValue(new BigInteger(dns_ct_str.substring(2 * i, 2 * i + 2), 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
          }
          for (int i = dns_ct_str.length() / 2; i < ODOH.HTTP_REQUEST_MAX_LENGTH; i = i + 1) {
            http_bytes_ciphertext[i].mapValue(new BigInteger("0", 16), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());
          }

          // END OF CHANNEL OPENING INPUTS //////////////////////////////////////////////////////////////////////////// 

          // ODOH INPUTS 

          targethost_start_index.mapValue(new BigInteger("16"), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());

          first_crlf_index.mapValue(new BigInteger("108"), CircuitGenerator.__getActiveCircuitGenerator().__getCircuitEvaluator());


        } catch (Exception ex) {
          System.out.println("FILE NOT FIND OR LINE NOT READ");
        }


      }
      public void post() {
        System.out.println("Circuit Output: ");

      }

    });

  }



  public void __init() {
    comm = new FieldElement(new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"), new BigInteger("0"));
    http_bytes_ciphertext = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{ODOH.HTTP_REQUEST_MAX_LENGTH}, 8);
    key = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{16}, 8);
    iv = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{12}, 8);
    targethost_start_index = new UnsignedInteger(8, new BigInteger("0"));
    first_crlf_index = new UnsignedInteger(8, new BigInteger("0"));
    output = (UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{32}, 8);
    output_Fp = new FieldElement(new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"), new BigInteger("0"));
  }

  public FieldElement comm;
  public UnsignedInteger[] http_bytes_ciphertext;
  public UnsignedInteger[] key;
  public UnsignedInteger[] iv;
  public UnsignedInteger targethost_start_index;
  public UnsignedInteger first_crlf_index;
  public UnsignedInteger[][] values;
  public UnsignedInteger[] output;
  public FieldElement output_Fp;

  @Override
  public void __defineInputs() {
    super.__defineInputs();
    comm = FieldElement.createInput(this, new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));



    http_bytes_ciphertext = (UnsignedInteger[]) UnsignedInteger.createInputArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(http_bytes_ciphertext), 8);












  }
  @Override
  public void __defineOutputs() {
    super.__defineOutputs();









  }
  @Override
  public void __defineVerifiedWitnesses() {
    super.__defineVerifiedWitnesses();

    targethost_start_index = UnsignedInteger.createVerifiedWitness(this, 8);
    first_crlf_index = UnsignedInteger.createVerifiedWitness(this, 8);



    key = (UnsignedInteger[]) UnsignedInteger.createVerifiedWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(key), 8);
    iv = (UnsignedInteger[]) UnsignedInteger.createVerifiedWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(iv), 8);















  }
  @Override
  public void __defineWitnesses() {
    super.__defineWitnesses();

















  }
  public void outsource() {

    // (1) CHANNEL OPENING - Amortized (see 'channel_openings' circuit) 
    UnsignedInteger[] concat = xjsnark.util_and_sha.Util.concat(key, iv);
    UnsignedInteger concat_256 = xjsnark.util_and_sha.Util.convert_8_to_256_array(xjsnark.util_and_sha.Util.concat((UnsignedInteger[]) UnsignedInteger.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{4}, 8), concat))[0].copy(256);
    FieldElement comm_cal = PoseidonHash.poseidon_hash(new FieldElement[]{new FieldElement(new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"), new BigInteger("0")), FieldElement.instantiateFrom(new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"), concat_256).copy()}).copy();
    comm.forceEqual(comm_cal);

    // Decrypted application data 
    UnsignedInteger[] http_bytes = AES_GCM.aes_gcm_decrypt(key, iv, http_bytes_ciphertext);

    // Perform the ODOH test that does the following: 
    // (2) Parse and Extract - the starts of the 'targethost' label and 'crlf' characters are given 
    // (3) Policy Check - verify that the hardcoded resolver name is present at targest_host_index: 
    // 'targethost=example.com' if example.com is the resolver 
    // Also verify that the targethost is in the first line (that is, before the first CRLF index) 
    ODOH.test_odoh(http_bytes, targethost_start_index.copy(8), first_crlf_index.copy(8));
  }

  public void __generateSampleInput(CircuitEvaluator evaluator) {
    __generateRandomInput(evaluator);
  }

}
