/**
 * Read resource [name] as string.
 * Whitespace at the beginning and ending of the string is automatically removed.
 */
fun resource(name: String) = lazy {
	{}::class.java.getResource(name)?.readText()?.trim() ?: error("Unable to read resource $name.")
}
