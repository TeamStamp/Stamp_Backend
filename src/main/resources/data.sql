
INSERT INTO User_Entity(Id,Nickname,Email,Password,Img_Url) VALUES (1,'문공표','asdasd@gmail.com','asdasd','sadasdasfxc');
INSERT INTO Crs_Entity (Crs_Name,Is_Accept,Img_Url,User_Id) VALUES ('Crs1',1,'sadasd',1);
INSERT INTO Crs_Entity (Crs_Name,Is_Accept,Img_Url,User_Id) VALUES ('Crs2',1,'sadasd',1);
INSERT INTO Day_Entity (Dayx,Crs_Id) VALUES (1,1);
INSERT INTO Day_Entity (Dayx,Crs_Id) VALUES (2,1);
INSERT INTO Day_Entity (Dayx,Crs_Id) VALUES (3,1);
INSERT INTO Day_Entity (Dayx,Crs_Id) VALUES (1,2);
INSERT INTO Plc_Entity (Plc_Name,Lat,Lng,Img_Url,Category,Is_Accept,User_Id) VALUES ('Plc1','123','123','sadasd','음식점',1,1);
INSERT INTO Plc_Entity (Plc_Name,Lat,Lng,Img_Url,Category,Is_Accept,User_Id) VALUES ('Plc2','321','321','sadasdss','도서관',1,1);
INSERT INTO Day_In_Plc (Day_Id,Plc_Id) VALUES (1,1);
INSERT INTO Day_In_Plc (Day_Id,Plc_Id) VALUES (1,2);
INSERT INTO Day_In_Plc (Day_Id,Plc_Id) VALUES (2,2);