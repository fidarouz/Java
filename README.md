# 🍗 Restaurant Inventory Management System

This is a Java-based inventory management system tailored for Afian Fried Chicken, developed as a group project for the CSC248 course at UiTM Tapah. The system was designed to help restaurant staff efficiently manage and track ingredient inventory using custom-built data structures.

## 💡 Overview

The application simulates a basic inventory management system with capabilities such as:
- Adding and storing ingredient stock details
- Updating availability status
- Removing discontinued stock items
- Searching and displaying specific stock information
- Splitting items by availability (In Stock / Out of Stock)
- Calculating total stock cost
- Reading and writing stock data via text file

## 📁 Key Features

- ✅ Track ingredient attributes: ID, name, category, quantity, price, and availability
- 🔎 Search, update, or remove stock entries
- 📂 Categorize and display stock based on availability
- 🧮 Calculate total price (quantity × unit price)
- 📝 File-based data storage using `.txt`

## 🔧 Technologies & Data Structures

- Java (Core OOP)
- Custom **Linked List** for dynamic stock management
- Custom **Queue** for sequential stock processing
- File handling with `Scanner` and `StringTokenizer`
- Custom exception handling

## 🚀 Project Structure

Two main classes demonstrate the use of different data structures:
- `IngredientStockMain.java`: Inventory management using a **Linked List**
- `IngredientStockMainq.java`: Inventory management using a **Queue**

Both read from the same input file: `p.txt`.

## 🏫 Academic Info

- 📚 Course: CSC248 - Data Structures
- 🏛️ Faculty: UiTM Tapah, Perak
- 👨‍🏫 Lecturer: Nursyahidah binti Alias
- 👥 Group Members:
  - Muhammad Fidarous bin Abdul Hadi
  - Afian Syamil bin Khairul Anuar
  - Muhammad Hadi bin Mohd Asri
