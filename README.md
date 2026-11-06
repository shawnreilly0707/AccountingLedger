Accounting Ledger is a program that allows you to track your transactions and add deposits or payments
You can sort by today's month, today's year, or any previous month/year, or even the vendor

=======================================

<img width="373" height="172" alt="image" src="https://github.com/user-attachments/assets/87203159-0b66-4548-a515-92d5f1433d3c" />

<img width="378" height="198" alt="image" src="https://github.com/user-attachments/assets/df4745da-1222-4a76-9d3d-1cfe4c0d8f28" />

<img width="369" height="241" alt="image" src="https://github.com/user-attachments/assets/1035b8f0-017c-4403-9397-065fd253d750" />

=======================================

An interesting piece of this program:
At the start of each program initialization, it reads through the transactions.csv file,
splits by the dividers, and adds each entry by each variable to an invisible array of entries
(that array is used for a lot of the background work you dont see outside the code)
