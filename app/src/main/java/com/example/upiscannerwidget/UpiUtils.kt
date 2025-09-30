package com.example.upiscannerwidget

object UpiUtils {

    fun isValidUpiUrl(url: String): Boolean {
        return try {
            when {
                // Standard UPI deep link format
                url.startsWith("upi://pay?") -> {
                    validateUpiParams(url)
                }
                // BHIM UPI format
                url.startsWith("paytm://upi/pay?") ||
                        url.startsWith("phonepe://pay?") ||
                        url.startsWith("gpay://upi/pay?") ||
                        url.startsWith("bhim://pay?") -> true
                // UPI ID format (user@provider)
                url.matches(Regex("^[a-zA-Z0-9.\\-_]+@[a-zA-Z]+$")) -> true
                else -> false
            }
        } catch (e: Exception) {
            false
        }
    }

    private fun validateUpiParams(url: String): Boolean {
        return try {
            val uri = android.net.Uri.parse(url)
            // Check for required parameters
            val pa = uri.getQueryParameter("pa") // payee address
            val pn = uri.getQueryParameter("pn") // payee name

            // At minimum, a valid UPI URL should have a payee address
            !pa.isNullOrEmpty()
        } catch (e: Exception) {
            false
        }
    }
}