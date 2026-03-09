Day 6 – Retrofit Integration

 Retrofit was integrated into the application to fetch product data from a dummy API instead of using static data. The application now retrieves products from an online source and displays them in a RecyclerView using the MVVM architecture.

* Features Implemented

-- Connected the app to a dummy REST API
-- Fetched product data using Retrofit
-- Displayed API data in RecyclerView
-- Implemented error handling
-- Displayed a message when no internet connection occurs

 * Project Architecture

com.example.recyclerviewproductapp

data/
  -- ProductRepository.kt
  --  ProductApi.kt
  --  RetrofitClient.kt

ui/
  -- ProductListFragment.kt
  -- ProductDetailFragment.kt
  -- ProductAdapter.kt

viewmodel/
  -- ProductViewModel.kt
