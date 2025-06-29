CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
CURSOR savings_accounts IS
SELECT AccountID, Balance, CustomerID
FROM Accounts
WHERE AccountType = 'Savings';
    
v_interest_rate NUMBER := 0.01;
v_interest_amount NUMBER;
v_updated_count NUMBER := 0;
BEGIN
FOR account_rec IN savings_accounts LOOP
v_interest_amount := ROUND(account_rec.Balance * v_interest_amount, 2);
UPDATE Accounts
SET Balance = Balance + v_interest_amount,
LastModified = SYSDATE
WHERE AccountID = account_rec.AccountID;    
UPDATE Customers
SET Balance = Balance + v_interest_amount,
LastModified = SYSDATE
WHERE CustomerID = account_rec.CustomerID;   
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (Transaction_seq.NEXTVAL, account_rec.AccountID, SYSDATE, v_interest_amount, 'Interest');    
v_updated_count := v_updated_count + 1;
DBMS_OUTPUT.PUT_LINE('Applied $' || v_interest_amount || ' interest to account ' || account_rec.AccountID);
END LOOP; 
COMMIT;
END ProcessMonthlyInterest;
/
BEGIN
ProcessMonthlyInterest();
END;
/