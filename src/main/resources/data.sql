insert into brand (name, commercial_type) values
('NIKE', 'OR'),
('ABFRL', 'JIT');

ALTER TABLE brand ADD UNIQUE brand_commercialtype (name, commercial_type);