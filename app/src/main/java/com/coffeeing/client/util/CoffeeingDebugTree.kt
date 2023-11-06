package com.coffeeing.client.util

import timber.log.Timber

class CoffeeingDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement) =
        "${element.fileName}:${element.lineNumber}#${element.methodName}"
}