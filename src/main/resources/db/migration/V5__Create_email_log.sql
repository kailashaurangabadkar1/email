create table EMAIL_LOG (
    ID int not null,
    user_email_request_id int,
    user_id int,
    user_email varchar(200),
    triggerTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    sentTime TIMESTAMP,
    status varchar(20),
    createdBy varchar(20),
    createdAt TIMESTAMP
);