CREATE TABLE "roles"(
    "id" BIGINT NOT NULL,
    "role_name" TEXT NOT NULL
);
ALTER TABLE
    "roles" ADD PRIMARY KEY("id");
CREATE TABLE "users"(
    "id" BIGINT NOT NULL,
    "email" VARCHAR(255) NOT NULL,
    "password" VARCHAR(255) NOT NULL,
    "role_id" BIGINT NOT NULL,
    "created_at" DATE NOT NULL,
    "telegram_username" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "users" ADD PRIMARY KEY("id");
ALTER TABLE
    "users" ADD CONSTRAINT "users_email_unique" UNIQUE("email");
CREATE TABLE "patients"(
    "id" BIGINT NOT NULL,
    "user_id" BIGINT NOT NULL,
    "first_name" VARCHAR(255) NOT NULL,
    "last_name" VARCHAR(255) NOT NULL,
    "birth_date" DATE NOT NULL,
    "phone" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "patients" ADD PRIMARY KEY("id");
CREATE TABLE "test_types"(
    "id" BIGINT NOT NULL,
    "name" VARCHAR(255) NOT NULL,
    "description" VARCHAR(255) NOT NULL,
    "price" DECIMAL(8, 2) NOT NULL,
    "created_at" DATE NOT NULL
);
ALTER TABLE
    "test_types" ADD PRIMARY KEY("id");
CREATE TABLE "test_requests"(
    "id" BIGINT NOT NULL,
    "patient_id" BIGINT NOT NULL,
    "test_type_id" BIGINT NOT NULL,
    "status" VARCHAR(255) NOT NULL,
    "requested_at" DATE NOT NULL,
    "completed_at" DATE NOT NULL,
    "comment" TEXT NULL
);
ALTER TABLE
    "test_requests" ADD PRIMARY KEY("id");
CREATE TABLE "test_results"(
    "id" BIGINT NOT NULL,
    "test_request_id" BIGINT NOT NULL,
    "result_data" TEXT NOT NULL,
    "ready_at" DATE NOT NULL,
    "lab_technician_id" BIGINT NOT NULL,
    "delay" BOOLEAN NOT NULL
);
ALTER TABLE
    "test_results" ADD PRIMARY KEY("id");
CREATE TABLE "technician_test_types"(
    "id" BIGINT NOT NULL,
    "technician_id" BIGINT NOT NULL,
    "test_type_id" BIGINT NOT NULL,
    "assigned_at" DATE NOT NULL
);
ALTER TABLE
    "technician_test_types" ADD PRIMARY KEY("id");
ALTER TABLE
    "technician_test_types" ADD CONSTRAINT "technician_test_types_technician_id_foreign" FOREIGN KEY("technician_id") REFERENCES "users"("id");
ALTER TABLE
    "users" ADD CONSTRAINT "users_role_id_foreign" FOREIGN KEY("role_id") REFERENCES "roles"("id");
ALTER TABLE
    "technician_test_types" ADD CONSTRAINT "technician_test_types_test_type_id_foreign" FOREIGN KEY("test_type_id") REFERENCES "test_types"("id");
ALTER TABLE
    "test_results" ADD CONSTRAINT "test_results_test_request_id_foreign" FOREIGN KEY("test_request_id") REFERENCES "test_requests"("id");
ALTER TABLE
    "patients" ADD CONSTRAINT "patients_user_id_foreign" FOREIGN KEY("user_id") REFERENCES "users"("id");
ALTER TABLE
    "test_requests" ADD CONSTRAINT "test_requests_test_type_id_foreign" FOREIGN KEY("test_type_id") REFERENCES "test_types"("id");
ALTER TABLE
    "test_results" ADD CONSTRAINT "test_results_lab_technician_id_foreign" FOREIGN KEY("lab_technician_id") REFERENCES "users"("id");
ALTER TABLE
    "test_requests" ADD CONSTRAINT "test_requests_patient_id_foreign" FOREIGN KEY("patient_id") REFERENCES "patients"("id");