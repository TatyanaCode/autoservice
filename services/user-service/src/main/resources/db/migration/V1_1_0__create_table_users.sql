CREATE TABLE roles (
	created timestamp(6) NULL,
	id bigserial NOT NULL,
	updated timestamp(6) NULL,
	role_name varchar(255) NULL,
	CONSTRAINT roles_pkey PRIMARY KEY (id)
);

CREATE TABLE users (
	created timestamp(6) NULL,
	id bigserial NOT NULL,
	updated timestamp(6) NULL,
	email varchar(255) NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	"password" varchar(255) NULL,
	status varchar(255) NULL,
	username varchar(255) NULL,
	CONSTRAINT users_pkey PRIMARY KEY (id),
	CONSTRAINT users_status_check CHECK (((status)::text = ANY ((ARRAY['ACTIVE'::character varying, 'NOT_ACTIVE'::character varying, 'DELETED'::character varying])::text[])))
);

CREATE TABLE user_roles (
	role_id int8 NOT NULL,
	user_id int8 NOT NULL,
	CONSTRAINT fk_role_id FOREIGN KEY (role_id) REFERENCES roles(id),
	CONSTRAINT fk_user_id FOREIGN KEY (user_id) REFERENCES users(id)
);

