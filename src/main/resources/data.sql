
INSERT INTO User_Entity(Id,Nickname,Email,Password,Img_Url) VALUES (1,'문공표','asdasd@gmail.com','asdasd','sadasdasfxc');
INSERT INTO Crs_Entity (Crs_Name,Is_Accept,Img_Url,User_Id) VALUES ('Crs1',1,'sadasd',1);
INSERT INTO Crs_Entity (Crs_Name,Is_Accept,Img_Url,User_Id) VALUES ('Crs2',0,'sadasd',1);
INSERT INTO Day_Entity (Dayx,Crs_Id) VALUES (1,1);
INSERT INTO Day_Entity (Dayx,Crs_Id) VALUES (2,1);
INSERT INTO Day_Entity (Dayx,Crs_Id) VALUES (1,2);
INSERT INTO Plc_Entity (Plc_Name,Lat,Lng,Img_Url,Category,Is_Accept,User_Id,Cost) VALUES ('Plc1','123','123','sadasd','음식점',1,1,50000);
INSERT INTO Plc_Entity (Plc_Name,Lat,Lng,Img_Url,Category,Is_Accept,User_Id,Cost) VALUES ('Plc2','321','321','sadasdss','도서관',1,1,5000);
INSERT INTO Day_In_Plc (Date_Time,Day_Id,Plc_Id) VALUES ('2023-05-11T12:02:00',1,1);
INSERT INTO Day_In_Plc (Date_Time,Day_Id,Plc_Id) VALUES ('2023-05-11T18:30:00',1,2);
INSERT INTO Day_In_Plc (Date_Time,Day_Id,Plc_Id) VALUES ('2023-05-12T07:45:00',2,2);
INSERT INTO Plc_Cmt (User_Id,Plc_Id,Content) VALUES (1,2,'ㅋㅋㅋㅋㅋㅋㅋ');
INSERT INTO Plc_Cmt (User_Id,Plc_Id,Content) VALUES (1,2,'ㅎㅇ요');
INSERT INTO Plc_Cmt (User_Id,Plc_Id,Content) VALUES (1,2,'ㄹㅈㄷ');
INSERT INTO Crs_Cmt (User_Id,Crs_Id,Content) VALUES (1,2,'가');
INSERT INTO Crs_Cmt (User_Id,Crs_Id,Content) VALUES (1,2,'나');
INSERT INTO Crs_Cmt (User_Id,Crs_Id,Content) VALUES (1,2,'다');
