## Day 7 – Week 1 Completion

Focused on completing the first week of the Android development project by improving the architecture, UI state handling, and overall user experience of the application. The app now fetches products from an API, displays them in a RecyclerView with a CardView design, and provides proper loading and error states.

## Features Implemented

 1. Sealed UI State Implementation

A sealed class was used to manage different UI states in the app:

* **Loading** – Shows a progress bar while data is being fetched.
* **Success** – Displays product data in the RecyclerView.
* **Error** – Shows an error message if the API fails or there is no internet connection.

### 2. Progress Bar Integration

A progress bar was added to improve user experience by indicating when data is being loaded from the API.

### 3. Improved Repository Logic

The repository layer was improved to:

* Handle API requests using Retrofit.
* Catch exceptions using try/catch blocks.
* Return appropriate UI states to the ViewModel.

### 4. RecyclerView UI Enhancement

* Products are displayed using **CardView with ConstraintLayout**.
* Each card shows:

  * Product Image
  * Product Name
  * Product Price
  * Add to Cart Button

### 5. Product Detail Navigation

Clicking on a product opens a **Product Detail Screen** displaying:

* Product Image
* Product Name
* Product Price

Navigation between screens is handled using the **Navigation Component with Safe Args**.

### 6. Add to Cart Functionality

Each product card includes an **Add to Cart button**.
When clicked:
* A toast message appears confirming the item has been added to the cart.

### 7. Error Handling

If the API request fails or there is no internet connection, an appropriate error message is shown to the user.

## Screenshots

(Add screenshots of the following)

* Product List Screen
  <img width="1080" height="2400" alt="Screenshot_20260309_185920" src="https://github.com/user-attachments/assets/00bfb26b-a26b-4144-a1f2-f7a5b9e60b72" />

* Product Detail Screen
* Loading State
* Add to Cart Toast Message

## Outcome

The application is now a fully functional API-based product listing app that follows MVVM architecture and handles loading, success, and error states efficiently.

Week 1 of the Android development project has been successfully completed with a working application and improved code structure.
