DECLARE
CURSOR vip_cursor IS
SELECT CustomerID, Balance
FROM Customers
WHERE Balance > 10000
AND (is_vip = 'FALSE' OR is_vip IS NULL);
    
v_vip_amount NUMBER := 10000;
BEGIN
FOR vip_record IN vip_cursor LOOP
UPDATE Customers SET is_vip = 'TRUE', vip_since = SYSDATE
WHERE CustomerID = vip_record.CustomerID;
DBMS_OUTPUT.PUT_LINE('Promoted customer ID: ' || vip_record.CustomerID || ' with balance: $' || vip_record.Balance);
END LOOP;  
COMMIT;
END;
