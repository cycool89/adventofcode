using System;

namespace lib
{
    public static class Utils
    {
        public static long BinToDec(string binary)
        {
            return Convert.ToInt64(binary.Length > 0 ? binary : "0", 2);
        }
    }
}