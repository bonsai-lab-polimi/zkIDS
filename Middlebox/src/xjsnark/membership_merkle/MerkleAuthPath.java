package xjsnark.membership_merkle;

/*Generated by MPS */

import backend.auxTypes.StructDefinition;
import backend.auxTypes.UnsignedInteger;
import java.math.BigInteger;
import backend.auxTypes.FieldElement;
import backend.structure.CircuitGenerator;
import backend.auxTypes.Bit;
import backend.auxTypes.ConditionalScopeTracker;
import xjsnark.poseidon.PoseidonHash;
import util.Util;
import java.util.ArrayList;
import backend.auxTypes.VariableState;
import backend.auxTypes.IAuxType;

public class MerkleAuthPath extends StructDefinition {


  public UnsignedInteger directionSelector = new UnsignedInteger(64, new BigInteger("0"));
  public FieldElement[] digests = (FieldElement[]) FieldElement.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{non_membership.HEIGHT}, new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));
  public MerkleAuthPath() {
    digests = (FieldElement[]) FieldElement.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{non_membership.HEIGHT}, new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));
  }
  public MerkleAuthPath(UnsignedInteger inputDS, FieldElement[] inputDigests) {
    directionSelector.assign(inputDS, 64);
    digests = inputDigests;
  }
  public FieldElement computeMerkleRoot(FieldElement leaf) {
    Bit[] directionBits = directionSelector.getBitElements();
    FieldElement currentDigest = leaf.copy();
    FieldElement[] inputToNextHash = (FieldElement[]) FieldElement.createZeroArray(CircuitGenerator.__getActiveCircuitGenerator(), new int[]{2}, new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));

    for (int i = 0; i < non_membership.HEIGHT; i++) {
      for (int j = 0; j < 2; j++) {
        {
          Bit bit_a0a0e0o = directionBits[i].copy();
          boolean c_a0a0e0o = CircuitGenerator.__getActiveCircuitGenerator().__checkConstantState(bit_a0a0e0o);
          if (c_a0a0e0o) {
            if (bit_a0a0e0o.getConstantValue()) {
              inputToNextHash[j].assign((j >= 1 ? currentDigest : digests[i]));
            } else {
              inputToNextHash[j].assign((j < 1 ? currentDigest : digests[i]));

            }
          } else {
            ConditionalScopeTracker.pushMain();
            ConditionalScopeTracker.push(bit_a0a0e0o);
            inputToNextHash[j].assign((j >= 1 ? currentDigest : digests[i]));

            ConditionalScopeTracker.pop();

            ConditionalScopeTracker.push(new Bit(true));

            inputToNextHash[j].assign((j < 1 ? currentDigest : digests[i]));
            ConditionalScopeTracker.pop();
            ConditionalScopeTracker.popMain();
          }

        }
      }
      currentDigest.assign(PoseidonHash.poseidon_hash(inputToNextHash));
    }
    return currentDigest;
  }


  public void __makeInput() {

    directionSelector = UnsignedInteger.createInput(CircuitGenerator.__getActiveCircuitGenerator(), 64);








    digests = (FieldElement[]) FieldElement.createInputArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(digests), new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));












  }


  public void __makeOutput() {
    UnsignedInteger.makeOutput(CircuitGenerator.__getActiveCircuitGenerator(), directionSelector);

    FieldElement.makeOutput(CircuitGenerator.__getActiveCircuitGenerator(), digests);




  }


  public void __makeWitness() {


    directionSelector = UnsignedInteger.createWitness(CircuitGenerator.__getActiveCircuitGenerator(), 64);







    digests = (FieldElement[]) FieldElement.createWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(digests), new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));















  }


  public void __makeVerifiedWitness() {

    directionSelector = UnsignedInteger.createVerifiedWitness(CircuitGenerator.__getActiveCircuitGenerator(), 64);














    digests = (FieldElement[]) FieldElement.createVerifiedWitnessArray(CircuitGenerator.__getActiveCircuitGenerator(), Util.getArrayDimensions(digests), new BigInteger("21888242871839275222246405745257275088548364400416034343698204186575808495617"));















  }

  public void __alignAndPackAll() {

    ArrayList<VariableState> states = new ArrayList();
    states.add(directionSelector.getState());

    for (int i = 0; i < digests.length; i++) {
      states.add(digests[i].getState());
    }






    for (VariableState state : states) {
      state.setPackedAhead(true);
      state.setMustBeWithinRange(true);
      state.setConditionallySplittedAndAlignedAhead(true);
    }

  }
  public static Class<?> __getClassRef() {
    return MerkleAuthPath.class;
  }

  public StructDefinition __copy() {
    return null;
  }
  public int[] __getBasicElementsDetails() {
    return null;
  }
  public ArrayList<IAuxType> __getBasicElements() {
    ArrayList<IAuxType> list = new ArrayList();
    list.add(directionSelector);

    for (int i = 0; i < digests.length; i++) {
      list.add(digests[i]);
    }






    return list;
  }
}
