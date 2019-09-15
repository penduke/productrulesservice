@Service
@Transactional

spring.jpa.hibernate.ddl-auto=none


-- SCHEMA.SQL

CREATE TABLE brand(
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  commercial_type CHAR(10) NOT NULL
);

ALTER TABLE brand ADD UNIQUE brand_commercialtype (name, commercial_type);


-- DATA.SQL

insert into brand (name, commercial_type) values
('NIKE', 'OR'),
('ABFRL', 'JIT');