#### 2023-11-15

##### Documentation Changes

* **CHANGELOG:**  update CHANGELOG.md with recent modifications (4994edcc)
* **README:**
  *  check completion for max order size validation rule (2b691874)
  *  document error for orders exceeding 20 items (221538be)
  *  document error for beverage-only orders (809e09ae)
  *  specify no benefits for orders under 10,000 won (89295544)
  *  add badge awarding based on total benefit amount (af14ba54)
  *  mark 'Expected Payment Amount After Discount' as complete (d15a9e26)
  *  update expected payment calculation with floor condition (59799a70)
  *  add calculation of total benefit amount (5ca8c085)
  *  update benefit details section with discount calculations (b19f79d4)
  *  outline complimentary menu conditions (87b4f7ee)
  *  specify total amount calculation before discount (5c2c44e0)
  *  add string conversion for ordered menus (a97eaa1c)
  *  detail menu input error handling (94ada8b9)
  *  validate visit date input (7341eb0b)
  *  add Christmas promotion project details (71b1372c)

##### New Features

* **showEventBadge:**  implement badge awarding based on total benefits (c74e60a8)
* **showAfterDiscount:**  implement logic for final amount after discounts (a7ec653d)
* **showTotalBenefit:**  calculate and display total benefit amount (e794cb52)
* **showBenefitDetails:**  implement logic for benefit amounts and details (64790db3)
* **showComplimentaryMenu:**  add champagne to complimentary items for large orders (d38d0fd8)
* **showTotalAmount:**  calculate total amount before discount (2b76fdb0)
* **showOrderMenus:**  implement menu item string conversion (608e68f4)
* **output:**  add welcome message and event preview (80cafc95)
* **input:**
  *  implement error handling for menu and quantity (7a751adf)
  *  implement visit date validation (22218a2e)

##### Bug Fixes

* **Validator:**
  *  ensure notBeverage returns false on loop exit (f4d42799)
  *  correct the item count extraction in order counting (9ce317c7)
  *  implement check for max order size (adbf28d8)
* **Validatior:**  enforce food item with beverage orders (1ecda961)
* **Event:**  exclude benefits for orders below 10,000 won (d855f850)
* **showComplimentaryMenu:**  add quantity to complimentary menu output (3ce5b61d)

##### Refactors

* **Menus:**  add findByName method to Menus enum (8c9ba904)
* **OutputView:**  consolidate common print operations in printTitle (b906ae14)
* **Planner:**
  *  reorganize method order for readability (5555e47d)
  *  rename methods for clarity and consistency (2d44d039)
  *  centralize Event instance as a private field (f6d191c5)
  *  encapsulate Event instance as a private field (2bd3f584)
* **Badge:**  consolidate badge-related constants into Badge enum (c5e43d94)
* **Event:**  add totalAmount parameter to isOverMinAmount (b94b9dc1)
* **structure:**  reorganize package layout for classes (ebef03bd)
* **constants:**  use constants for date range boundaries (82eea5ce)

##### Tests

* **ChristmasTest:**
  *  refine tests to use containsExactly for precision (c34e6008)
  *  replace hardcoded totalAmount with calculation method (6fa73a8d)
  *  ensure error for orders with more than 20 items (e2f2f9f8)
  *  add check for beverage-only orders (f5b35881)
  *  ensure no benefits for orders under 10,000 won (0689ed56)
  *  ensure correct post-discount amount calculation (80c462bb)
  *  ensure accurate calculation of total benefit amount (4fdad520)
  *  add tests for calculating and displaying benefit details (cc97abb6)
  *  verify champagne is given for orders over 120k won (1e5d0cbd)
  *  add test for calculating total amount before discount (cd645395)
  *  ensure string creation for menu output (9af6239f)
  *  add validation tests for menu input (d88b6c73)
  *  add date validation tests (206efb9b)
* **showEventBadge:**  add tests for awarding event badges based on benefits (f2ba8d24)

