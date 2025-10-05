package edu.unc.comp301.a03connectcarolina;

public class CLEAlreadyScannedException extends RuntimeException {

  public CLEAlreadyScannedException(String message) {
    super(message);
  }

  public CLEAlreadyScannedException() {
    super("Invalid grade!");
  }
}
