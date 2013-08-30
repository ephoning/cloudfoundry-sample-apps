DELIMITER $$

DROP PROCEDURE IF EXISTS test.proc_to_insert$$ 

CREATE PROCEDURE test.proc_to_insert(IN _rows_to_insert INT)
BEGIN

DECLARE counter INT DEFAULT 0;

DECLARE customer_ID INT;
DECLARE address_ID INT;

WHILE counter < _rows_to_insert DO

	INSERT INTO `test`.`ADDRESS`
	(`HOUSENUMBER`,`STREET`,`CITY`,`STATE`,`COUNTRY`, `OWNERTYPEID`, `ADDRESSTYPEID`)
	VALUES
	(CONCAT(100,counter*2), CONCAT('Street ',(counter*3+counter*2)), 'Holulu','CA','USA', null, 1);
	
	SET address_ID=LAST_INSERT_ID();
	
	INSERT INTO `test`.`Customer`
	(`CUSTOMERNAME`, `MEMBERSINCE`, `BALANCE`, `ADDRESSID`)
	VALUES
	(CONCAT('Customer ', counter), DATE_ADD('2013-01-01', INTERVAL counter DAY), 100.22-counter*1.23, address_ID);
	
	SET customer_ID=LAST_INSERT_ID();

	INSERT INTO `test`.`CONTACT`
	(`PHONENUMBER`,`PHONETYPE`,`CONTACTTYPE`,`EMAILID`,`CUSTOMERID`)
	VALUES
	('408-100-0000','Cell','eMail','e@kme.com',customer_ID);

	INSERT INTO `test`.`CREDITCARD`
	(`CARDNUMBER`,`SECURITYCODE`,`EXPDATE`,`CARDTYPE`,`CUSTOMERID`)
	VALUES
	('452342312322', '222', CURDATE(), 'VISA', customer_ID);

    SET counter = counter + 1;
END WHILE;

END;