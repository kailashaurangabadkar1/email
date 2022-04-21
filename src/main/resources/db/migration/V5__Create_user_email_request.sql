create table USER_EMAIL_REQUEST (
    ID int not null,
    segment_id int,
    template_id int,
    sender varchar(200) not null,
    to_recipient varchar(3000),
    cc_recipient varchar(3000),
    bcc_recipient varchar(3000),
    createdBy varchar(20),
    createdAt TIMESTAMP
);