create extension if not exists "uuid-ossp";

-- role init.
INSERT INTO kuartz_uaa.uaa_role (id, created_at, deleted_at, deleted, updated_at, uuid, code, default_role, description, name) VALUES (nextval('kuartz_uaa.role_seq'), current_timestamp, null, null, current_timestamp, uuid_generate_v4(), 'admin', false, 'Admin rolüdür.', 'Admin');
INSERT INTO kuartz_uaa.uaa_role (id, created_at, deleted_at, deleted, updated_at, uuid, code, default_role, description, name) VALUES (nextval('kuartz_uaa.role_seq'), current_timestamp, null, null, current_timestamp, uuid_generate_v4(), 'temelRol', true, 'Temel Roldür', 'Temel Rol');
INSERT INTO kuartz_uaa.uaa_role (id, created_at, deleted_at, deleted, updated_at, uuid, code, default_role, description, name) VALUES (nextval('kuartz_uaa.role_seq'), current_timestamp, null, null, current_timestamp, uuid_generate_v4(), 'bosRol', false, 'Boş Rol 1', 'Boş Rol 1');
INSERT INTO kuartz_uaa.uaa_role (id, created_at, deleted_at, deleted, updated_at, uuid, code, default_role, description, name) VALUES (nextval('kuartz_uaa.role_seq'), current_timestamp, null, null, current_timestamp, uuid_generate_v4(), 'bosRol2', false, 'Boş Rol 2', 'Boş Rol 2');

-- role privilage reletaion
INSERT INTO kuartz_uaa.uaa_rel_role_privilege (id,created_at,deleted_at,updated_at,uuid,role_id, privilege_id) select nextval('kuartz_uaa.role_privilege_seq') as id,current_timestamp as created_at ,null as deleted_at,current_timestamp as updated_at,uuid_generate_v4() as uiid,(select id from kuartz_uaa.uaa_role role where role.code = 'temelRol') as role_id, (select id from kuartz_uaa.uaa_privilege pri where pri.code = 'temelYetki') as privilige_id;
INSERT INTO kuartz_uaa.uaa_rel_role_privilege (id,created_at,deleted_at,updated_at,uuid,role_id, privilege_id) select nextval('kuartz_uaa.role_privilege_seq') as id,current_timestamp as created_at ,null as deleted_at,current_timestamp as updated_at,uuid_generate_v4() as uiid,(select id from kuartz_uaa.uaa_role role where role.code = 'admin') as role_id, (select id from kuartz_uaa.uaa_privilege pri where pri.code = 'admin') as privilige_id;
INSERT INTO kuartz_uaa.uaa_rel_role_privilege (id,created_at,deleted_at,updated_at,uuid,role_id, privilege_id) select nextval('kuartz_uaa.role_privilege_seq') as id,current_timestamp as created_at ,null as deleted_at,current_timestamp as updated_at,uuid_generate_v4() as uiid,(select id from kuartz_uaa.uaa_role role where role.code = 'admin') as role_id, (select id from kuartz_uaa.uaa_privilege pri where pri.code = 'uaa') as privilige_id;

-- COMPANY 1
INSERT INTO kuartz_uaa.uaa_contact (id, created_at, deleted_at, deleted, updated_at, uuid, adress, gsm1, gsm2, mail, tel, web) VALUES (nextval('kuartz_uaa.uaa_contact_seq'), current_timestamp, null, null, null, uuid_generate_v4(), 'Balgat Ankara', '05533226125', null, 'mail@company1.com', null, 'www.company1.com');

INSERT INTO kuartz_uaa.uaa_company (id, created_at, deleted_at, deleted, updated_at, uuid, country, name, short_name, contact_id) VALUES (nextval('kuartz_uaa.uaa_company_seq'), current_timestamp, null, null, null, uuid_generate_v4(), 'TR', 'Company 1', 'C1', (select id from kuartz_uaa.uaa_contact where mail = 'mail@company1.com'));

-- COMPANY 2
INSERT INTO kuartz_uaa.uaa_contact (id, created_at, deleted_at, deleted, updated_at, uuid, adress, gsm1, gsm2, mail, tel, web) VALUES (nextval('kuartz_uaa.uaa_contact_seq'), current_timestamp, null, null, null, uuid_generate_v4(), 'METU Ankara', '05533226125', null, 'mail@company2.com', null, 'www.company2.com');

INSERT INTO kuartz_uaa.uaa_company (id, created_at, deleted_at, deleted, updated_at, uuid, country, name, short_name, contact_id) VALUES (nextval('kuartz_uaa.uaa_company_seq'), current_timestamp, null, null, null, uuid_generate_v4(), 'TR', 'Company 2', 'C2', (select id from kuartz_uaa.uaa_contact where mail = 'mail@company2.com'));


-- PERSON 1
INSERT INTO kuartz_uaa.uaa_contact (id, created_at, deleted_at, deleted, updated_at, uuid, adress, gsm1, gsm2, mail, tel, web) VALUES (nextval('kuartz_uaa.uaa_contact_seq'), current_timestamp, null, null, null, uuid_generate_v4(), 'Kırkkonaklar Ankara', '05533226321', null, 'celebikutay@gmail.com', null, 'www.kutaycelebi.com');

INSERT INTO kuartz_uaa.uaa_person (id, created_at, deleted_at, deleted, updated_at, uuid, birthday, gender, identification_number, last_name, mid_name, name, nationality, title, company_id, contact_id) VALUES (nextval('kuartz_uaa.uaa_person_seq'), current_timestamp, null, null, null, uuid_generate_v4(), '1995-01-13', 1, null, 'Çelebi', '', 'Kutay', 'TR', null, (select id from kuartz_uaa.uaa_company where name = 'Company 1'), (select id from kuartz_uaa.uaa_contact where mail = 'celebikutay@gmail.com'));

INSERT INTO kuartz_uaa.uaa_user_table (id, created_at, deleted_at, deleted, updated_at, uuid, email, enabled, expiration_date, locked_date, password, username, person_id) VALUES (nextval('kuartz_uaa.user_seq'), current_timestamp, null, null, null, uuid_generate_v4(), 'celebikutay@gmail.com', null, null, null, '$2a$10$UreawV45DPoTg9hCTlb7FOlXJ.xG9ldniucgJvSgMztZ5JwMFOdqi', 'kcelebi', (select id from kuartz_uaa.uaa_person where name='Kutay'));

INSERT INTO kuartz_uaa.uaa_rel_user_role (id,created_at,deleted_at,updated_at,uuid,user_id, role_id) select nextval('kuartz_uaa.USER_ROLE_SEQ') as id,current_timestamp as created_at,null as deleted_At,current_timestamp as updated_at,uuid_generate_v4() as uuid,(select id from kuartz_uaa.uaa_user_table uauser where uauser.username = 'kcelebi') as user_id,(select id from kuartz_uaa.uaa_role role where role.code = 'temelRol') as role_id ;
INSERT INTO kuartz_uaa.uaa_rel_user_role (id,created_at,deleted_at,updated_at,uuid,user_id, role_id) select nextval('kuartz_uaa.USER_ROLE_SEQ') as id,current_timestamp as created_at,null as deleted_At,current_timestamp as updated_at,uuid_generate_v4() as uuid,(select id from kuartz_uaa.uaa_user_table uauser where uauser.username = 'kcelebi') as user_id,(select id from kuartz_uaa.uaa_role role where role.code = 'admin') as role_id ;


-- PERSON 2
INSERT INTO kuartz_uaa.uaa_contact (id, created_at, deleted_at, deleted, updated_at, uuid, adress, gsm1, gsm2, mail, tel, web) VALUES (nextval('kuartz_uaa.uaa_contact_seq'), current_timestamp, null, null, null, uuid_generate_v4(), 'Kırkkonaklar Ankara', '+905386452123', null, 'azizerel@gmail.com', null, null);

INSERT INTO kuartz_uaa.uaa_person (id, created_at, deleted_at, deleted, updated_at, uuid, birthday, gender, identification_number, last_name, mid_name, name, nationality, title, company_id, contact_id) VALUES (nextval('kuartz_uaa.uaa_person_seq'), current_timestamp, null, null, null, uuid_generate_v4(), '1995-01-13', 1, null, 'Erel', '', 'Aziz', 'TR', null, (select id from kuartz_uaa.uaa_company where name = 'Company 2'), (select id from kuartz_uaa.uaa_contact where mail = 'azizerel@gmail.com'));

INSERT INTO kuartz_uaa.uaa_user_table (id, created_at, deleted_at, deleted, updated_at, uuid, email, enabled, expiration_date, locked_date, password, username, person_id) VALUES (nextval('kuartz_uaa.user_seq'), current_timestamp, null, null, null, uuid_generate_v4(), 'azizerel@gmail.com', null, null, null, '$2a$10$UreawV45DPoTg9hCTlb7FOlXJ.xG9ldniucgJvSgMztZ5JwMFOdqi', 'aerel', (select id from kuartz_uaa.uaa_person where name='Aziz'));

INSERT INTO kuartz_uaa.uaa_rel_user_role (id,created_at,deleted_at,updated_at,uuid,user_id, role_id) select nextval('kuartz_uaa.USER_ROLE_SEQ') as id,current_timestamp as created_at,null as deleted_At,current_timestamp as updated_at,uuid_generate_v4() as uuid,(select id from kuartz_uaa.uaa_user_table uauser where uauser.username = 'aerel') as user_id,(select id from kuartz_uaa.uaa_role role where role.code = 'temelRol') as role_id ;


--  client init.
INSERT INTO kuartz_uaa.uaa_client_detail (id, created_at, deleted_at, deleted, updated_at, uuid, acces_token_validity_seconds, additional_information, authorities, authorized_grant_types, auto_approve_scopes, client_id, client_secret, refresh_token_validity_seconds, registered_redirect_uri, scope) VALUES (nextval('kuartz_uaa.client_seq'), current_timestamp, null, null, current_timestamp, uuid_generate_v4(), 1500, null, 'role_user', 'password', null, 'test', '$2a$10$UreawV45DPoTg9hCTlb7FOlXJ.xG9ldniucgJvSgMztZ5JwMFOdqi', 1500, null, 'password');

INSERT INTO kuartz_uaa.uaa_resource (id, created_at, deleted_at, deleted, updated_at, uuid, resource_name) VALUES (nextval('kuartz_uaa.resource_seq'), current_timestamp, null, null, current_timestamp, uuid_generate_v4(), 'gateway,uaa');
insert into kuartz_uaa.client_resource_relation(client_id, resource_id) values (1,1)
