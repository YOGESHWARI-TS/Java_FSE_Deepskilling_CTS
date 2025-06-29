CREATE OR REPLACE PROCEDURE TransferFunds (
  p_from_account IN NUMBER,
  p_to_account IN NUMBER,
  p_amount IN NUMBER
) AS
  v_balance NUMBER;
BEGIN
  SELECT balance INTO v_balance
  FROM accounts
  WHERE AccountID = p_from_account;

  IF v_balance >= p_amount THEN
    UPDATE accounts
    SET balance = balance - p_amount
    WHERE AccountID = p_from_account;

    UPDATE accounts
    SET balance = balance + p_amount
    WHERE AccountID = p_to_account;

    COMMIT;
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
  END IF;
END;
/
EXEC TransferFunds(1, 3, 2000);