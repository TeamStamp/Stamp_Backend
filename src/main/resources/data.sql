
INSERT INTO Usr(nickname,email,password,salt,img_Url,is_Admin) VALUES ('문공표','asdasd@gmail.com','asdasd','aaaaaaaaaa','sadasdasfxc',false);
INSERT INTO Usr(nickname,email,password,salt,img_Url,is_Admin) VALUES ('tUser0','tUser0','1234','aaaa','sadasdasfxc',false);
INSERT INTO Crs (crs_Name,is_Accept,img_Url,usr) VALUES ('Crs1',1,'sadasd',1);
INSERT INTO Crs (crs_Name,is_Accept,img_Url,usr) VALUES ('Crs2',1,'sadfsd',2);
INSERT INTO Crs (crs_Name,is_Accept,img_Url,usr) VALUES ('Crs3',1,'sreqsd',2);
INSERT INTO Crs (crs_Name,is_Accept,img_Url,usr) VALUES ('Crs4',1,'sadazx',1);
INSERT INTO Crs (crs_Name,is_Accept,img_Url,usr) VALUES ('Crs5',1,'nbvasd',2);
INSERT INTO a_Day (dayx,crs) VALUES (1,1);
INSERT INTO a_Day (dayx,crs) VALUES (2,1);
INSERT INTO a_Day (dayx,crs) VALUES (3,1);
INSERT INTO a_Day (dayx,crs) VALUES (1,2);
INSERT INTO Plc (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc1','123','123','sadasd','음식점',1,1,50000);
INSERT INTO Plc (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc2','321','321','sadasdss','도서관',1,2,5000);
INSERT INTO Plc (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc3','351','351','sadasdss','편의점',1,1,5000);
INSERT INTO Plc (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc4','311','121','sadasdss','이공관',1,2,5000);
INSERT INTO Plc (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc5','121','221','sadasdss','전산실',1,1,5000);
INSERT INTO Plc (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc6','421','211','sxcvsdss','후생관',1,1,5000);
INSERT INTO Plc (plc_Name,lat,lng,img_Url,category,is_Accept,usr,cost) VALUES ('Plc7','426','218','sxcvbcss','예술관',1,1,5000);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-11T18:30:00',1,2);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-11T12:02:00',1,1);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-12T07:45:00',2,3);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-13T07:45:00',3,5);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-12T09:45:00',3,4);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-12T09:45:00',4,6);
INSERT INTO Day_In_Plc (date_Time,a_Day,plc) VALUES ('2023-05-12T09:45:00',4,7);
INSERT INTO Plc_Cmt (usr,plc,content) VALUES (1,2,'ㅋㅋㅋㅋㅋㅋㅋ');
INSERT INTO Plc_Cmt (usr,plc,content) VALUES (1,2,'ㅎㅇ요');
INSERT INTO Plc_Cmt (usr,plc,content) VALUES (1,2,'ㄹㅈㄷ');
INSERT INTO Crs_Cmt (usr,crs,content) VALUES (1,1,'코스댓글1');
INSERT INTO Crs_Cmt (usr,crs,content) VALUES (2,1,'코스댓글2');
INSERT INTO Crs_Cmt (usr,crs,content) VALUES (1,1,'코스댓글3');
INSERT INTO Crs_Cmt (usr,crs,content) VALUES (2,1,'코스댓글4');
INSERT INTO Visited_Plc (usr_Email,plc_Id,visited) VALUES ('kymokim',1,true);
INSERT INTO Visited_Plc (usr_Email,plc_Id,visited) VALUES ('kymokim',2,true);
INSERT INTO Visited_Plc (usr_Email,plc_Id,visited) VALUES ('kymokim',3,false);
INSERT INTO Visited_Plc (usr_Email,plc_Id,visited) VALUES ('kymokim',4,false);
INSERT INTO Visited_Plc (usr_Email,plc_Id,visited) VALUES ('kymokim',5,false);