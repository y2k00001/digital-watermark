drop table if exists audit;

create table audit(
serial_version_UID varchar(50) ,
id int(11)  not null ,
firm_id int(11) ,
sender varchar(50) ,
date datetime ,
advice varchar(50) ,
status int(11) , x
buy_id int(11) ,
sell_id int(11) ,
deleted varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists broadcast;

create table broadcast(
serial_version_UID varchar(50) ,
id int(11)  not null ,
date datetime ,
user_id int(11) ,
title varchar(50) ,
info varchar(50) ,
status int(11) ,
advice varchar(50) ,
deleted varchar(50) ,
truename varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists broadcastread;

create table broadcastread(
serial_version_UID varchar(50) ,
id int(11)  not null ,
read varchar(50) ,
username varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists buymesg;

create table buymesg(
serial_version_UID varchar(50) ,
id int(11)  not null ,
firm_id int(11) ,
sellid int(11) ,
figure varchar(50) ,
fw_id int(11) ,
buyfirm_name varchar(50) ,
document_no varchar(50) ,
applicant varchar(50) ,
issuer varchar(50) ,
application_date datetime ,
deliverytime1 datetime ,
deliverytime2 datetime ,
coaltype1 int(11) ,
coaltype2 int(11) ,
num varchar(50) ,
freight varchar(50) ,
price varchar(50) ,
shiptype int(11) ,
deliveryplace varchar(50) ,
transactionmode int(11) ,
acceptancemode int(11) ,
paymentmode int(11) ,
offerbond varchar(50) ,
performbond varchar(50) ,
kcal varchar(50) ,
sulfur varchar(50) ,
water varchar(50) ,
ash varchar(50) ,
vol1 varchar(50) ,
vol2 varchar(50) ,
kwater varchar(50) ,
ksulfur varchar(50) ,
kvol1 varchar(50) ,
kvol2 varchar(50) ,
gkcal varchar(50) ,
gsulfur varchar(50) ,
gvol1 varchar(50) ,
gvol2 varchar(50) ,
granularity varchar(50) ,
melting varchar(50) ,
hgi varchar(50) ,
remarks varchar(50) ,
deleted varchar(50) ,
status int(11) ,
coal_type3 varchar(50) ,
coal_type4 varchar(50) ,
ship_type1 varchar(50) ,
transaction_mode1 varchar(50) ,
acceptance_mode1 varchar(50) ,
payment_mode1 varchar(50) ,
advice varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists firm;

create table firm(
serial_version_UID varchar(50) ,
id int(11)  not null ,
firmname varchar(50) ,
firmtype int(11) ,
represent varchar(50) ,
represent_idcard varchar(50) ,
area varchar(50) ,
email varchar(50) ,
telephone varchar(50) ,
fax varchar(50) ,
postal varchar(50) ,
register_fund varchar(50) ,
license_no varchar(50) ,
org_no varchar(50) ,
certificate_no varchar(50) ,
tax_no varchar(50) ,
bankname varchar(50) ,
bank_no varchar(50) ,
coalmesg varchar(50) ,
transportmesg varchar(50) ,
firminfo varchar(50) ,
treasurername varchar(50) ,
treasurertelephone varchar(50) ,
treasureremail varchar(50) ,
status int(11) ,
deleted varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists firm_attach;

create table firm_attach(
serial_version_UID varchar(50) ,
id int(11)  not null ,
firm_id int(11) ,
image_type varchar(50) ,
image_url varchar(50) ,
image_name varchar(50) ,
create_time datetime ,
update_time datetime ,
deleted varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists firmworker;

create table firmworker(
serial_version_UID varchar(50) ,
id int(11)  not null ,
firm_id int(11) ,
truename varchar(50) ,
telephone varchar(50) ,
email varchar(50) ,
password varchar(50) ,
firmtype int(11) ,
type int(11) ,
deleted varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists firmworker_account;

create table firmworker_account(
serial_version_UID varchar(50) ,
id int(11)  not null ,
fw_id int(11) ,
figure varchar(50) ,
trans_flow_list varchar(50) ,
amount varchar(50) ,
freeze_amount varchar(50) ,
create_time datetime ,
update_time datetime ,
deleted varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists personmesg;

create table personmesg(
serial_version_UID varchar(50) ,
id int(11)  not null ,
pep_id int(11) ,
sender varchar(50) ,
date datetime ,
info varchar(50) ,
status varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists sellmesg;

create table sellmesg(
serial_version_UID varchar(50) ,
id int(11)  not null ,
firm_id int(11) ,
buyid int(11) ,
figure varchar(50) ,
fw_id int(11) ,
coaltype1 int(11) ,
coaltype2 int(11) ,
num varchar(50) ,
kcal varchar(50) ,
price varchar(50) ,
sulfur varchar(50) ,
prodarea varchar(50) ,
freight varchar(50) ,
vol1 varchar(50) ,
vol2 varchar(50) ,
sendarea varchar(50) ,
ash varchar(50) ,
water varchar(50) ,
offerbond varchar(50) ,
status int(11) ,
deleted varchar(50) ,
advice varchar(50) ,
firmname varchar(50) ,
represent varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists transactionbills;

create table transactionbills(
serial_version_UID varchar(50) ,
id int(11)  not null ,
buyid int(11) ,
sellid int(11) ,
agreementpath varchar(50) ,
sellmesg_id int(11) ,
buymesg_id int(11) ,
status int(11) ,
deleted varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists trans_flow;

create table trans_flow(
serial_version_UID varchar(50) ,
id bigint(20)  not null ,
fw_id int(11) ,
fw_name varchar(50) ,
trans_no varchar(50) ,
trans_type int(11) ,
trans_type_name varchar(50) ,
trans_amount varchar(50) ,
memo varchar(50) ,
create_time datetime ,
update_time datetime ,
url varchar(50) ,
deleted varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists user;

create table user(
serial_version_UID varchar(50) ,
id int(11)  not null ,
username varchar(50) ,
password varchar(50) ,
truename varchar(50) ,
telephone varchar(50) ,
type int(11) ,
deleted varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
drop table if exists verifyinfo;

create table verifyinfo(
serial_version_UID varchar(50) ,
id int(11)  not null ,
firm_id int(11) ,
sender varchar(50) ,
date datetime ,
info varchar(50) ,
status varchar(50) ,
 PRIMARY KEY (`id`) USING BTREE
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;
