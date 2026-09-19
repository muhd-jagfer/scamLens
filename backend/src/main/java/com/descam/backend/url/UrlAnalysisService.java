package com.descam.backend.url;

import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UrlAnalysisService
{
  public static final Pattern URL_PATTERN = Pattern.compile("https?://[^\\s]+", Pattern.CASE_INSENSITIVE);

  public String extractUrl(String message)
  {
    Matcher matcher = URL_PATTERN.matcher(message);
    if (matcher.find())
    {
      return matcher.group();
    }
    return null;
  }

  public String extractDomain(String url)
  {
    try 
    {
      URI uri = URI.create(url);
      return uri.getHost();
    } catch (Exception e) {
      return null;
    }
  }
}