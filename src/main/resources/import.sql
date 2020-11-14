insert into author (first_name, last_name, birth_place) values ('Stefan', 'Żeromski', 'Strawczyn');
insert into author (first_name, last_name, birth_place) values ('Adam', 'Mickiewicz', 'Zaosie');
insert into author  (first_name, last_name, birth_place) values ('Henryk', 'Sienkiewicz', 'Wola');

insert into book (borrow, category, isbn, pages, release_date, summary, title, author_id) values (0, 'POEM', '876065', 400, '1834-06-20', 'abcgfhfgh', "Pan Tadeusz", 2);
insert into book  (borrow, category, isbn, pages, release_date, summary, title, author_id) values (1, 'CLASSIC', '675345', 369, '1962-08-20', 'defhfghfgh', "W pustyni i w puszczy", 3);
insert into book  (borrow, category, isbn, pages, release_date, summary, title, author_id) values (1, 'HISTORY', '657345', 440, '1895-08-20', 'jklhfghfg', "Quo vadis", 3);
insert into book  (borrow, category, isbn, pages, release_date, summary, title, author_id) values (1, 'CLASSIC', '668555', 543, '1987-03-20', 'ghfghfghfi', "Ludzie bezdomni", 1);

insert into borrower_details (address, email, phone) values ('Kraków', 'jan@onet.pl', '678456345');
insert into borrower_details (address, email, phone) values ('Wieliczka', 'tomasz@onet.pl', '987456234');

insert into borrower (first_name, last_name, borrower_details_id) values ('Jan', 'Nowak', 1);
insert into borrower (first_name, last_name, borrower_details_id) values ('Tomasz', 'Maj', 2);

insert into borrow (book_id, borrower_id, rental_date) values (2, 1, '2020-09-30');
insert into borrow (book_id, borrower_id, rental_date) values (3, 1, '2020-08-24');
insert into borrow (book_id, borrower_id, rental_date) values (4, 2, '2020-09-24');
