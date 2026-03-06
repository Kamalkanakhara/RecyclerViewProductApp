Day 5 – Coroutines Implementation

Day 5 focuses on implementing Kotlin Coroutines in the application to simulate API calls and manage asynchronous operations in a clean MVVM architecture.
The app now introduces a loading state and delay simulation before navigating to the product detail screen.

-  Features Added

-- Simulated API delay using delay()
-- Loading indicator (ProgressBar) while data is being fetched
-- Coroutine execution inside ViewModel
-- Navigation after coroutine completion
-- Basic error handling using LiveData

-  Project Architecture 
com.example.recyclerviewproductapp

data/
   ProductRepository.kt

ui/
   ProductListFragment.kt
   ProductDetailFragment.kt
   ProductAdapter.kt

viewmodel/
   ProductViewModel.kt
